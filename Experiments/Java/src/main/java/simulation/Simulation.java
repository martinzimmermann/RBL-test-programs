package simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.PrintStream;

import at.tugraz.ist.compiler.interpreter.DijkstraPlanFinder;
import at.tugraz.ist.compiler.interpreter.NoPlanFoundException;
import at.tugraz.ist.compiler.interpreter.Executor;

import rule.move;
import rule.pickup;
import rule.put;

public class Simulation {

    static int[][] TESTS = {
            // { grid size , num actors, scenario [
            // 0 = warehouse/no knowledge,
            // 1 = warehouse/knowledge,
            // 2 = maze
            // ]}

            { 5, 0, 0 }, { 5, 1, 0 }, { 5, 2, 0 }, { 5, 4, 0 },
            { 5, 0, 1 }, { 5, 1, 1 }, { 5, 2, 1 }, { 5, 4, 1 },
            { 5, 0, 2 },

            { 8, 0, 0 }, { 8, 1, 0 }, { 8, 2, 0 }, { 8, 4, 0 },
            { 8, 0, 1 }, { 8, 1, 1 }, { 8, 2, 1 }, { 8, 4, 1 },
            { 8, 0, 2 },

            { 11, 0, 0 }, { 11, 1, 0 }, { 11, 2, 0 }, { 11, 4, 0 },
            { 11, 0, 1 }, { 11, 1, 1 }, { 11, 2, 1 }, { 11, 4, 1 },
            //{ 11, 0, 2 },
    };

    static int EXECUTIONS_PER_TEST = 100;
    static int FETCHES = 100;

    static String PYTHONEXECUTABLE = "python3.6";
    static String PDDLPATH = "src" + File.separator + "main" + File.separator + "PDDL" + File.separator;
    static String PDDLDomain = PDDLPATH + "robotDomain.pddl";
    static String ENVWAREHOUSENAME = "maze-warehouse-";
    static String ENVMAZENAME = "maze-random-";
    static String RESULTPATH = "Results" + File.separator
            + "Results_" + new SimpleDateFormat("ddMMyy_HHmmss").format(new Date());
    static Random ran = new Random();

    public static String getDateTime() {
        return new SimpleDateFormat("dd.MM.yy HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) throws NoPlanFoundException, IOException {

        new File(RESULTPATH).mkdir();
        new File(RESULTPATH + File.separator + "log.txt").createNewFile();
        PrintStream fileOut = new PrintStream(RESULTPATH + File.separator + "log.txt");
        System.setOut(fileOut);

        System.out.println(getDateTime() + ": Start");
        for (int testNr = 0; testNr < TESTS.length; testNr ++) {
            FileWriter csvWriter = new FileWriter(RESULTPATH + File.separator + TESTS[testNr][0] + "_" + TESTS[testNr][1] + "_" + TESTS[testNr][2] + ".csv");
            csvWriter.append("Run, Time (ns), Steps, Plans, #Rules");
            for (int i = 0; i < FETCHES; i ++) {
                csvWriter.append(", Fetch" + i);
            }
            csvWriter.append("\n");
            csvWriter.flush();

            int size = TESTS[testNr][0];
            int agents = TESTS[testNr][1];
            String PDDLProblem = null;
            String gymEnv = null;

            switch (TESTS[testNr][2]){
                case 0: PDDLProblem = PDDLPATH + size + "x" + size + "_robotProblem.pddl";
                        gymEnv = ENVWAREHOUSENAME + size + "x" + size + "-v0";
                    break;
                case 1: PDDLProblem = PDDLPATH + size + "x" + size + "_warehouse_robotProblem.pddl";
                        gymEnv = ENVWAREHOUSENAME + size + "x" + size + "-v0";
                    break;
                case 2: PDDLProblem = PDDLPATH + size + "x" + size + "_robotProblem.pddl";
                        gymEnv = ENVMAZENAME + size + "x" + size + "-v0";
                    break;
            }
            
            System.out.println(getDateTime() + ": Starting " + size + " " + agents + " " + TESTS[testNr][2]);
            
            long startTime = System.nanoTime();
            long currentTime = startTime;
            int total_steps = 0;
            int total_plans = 0;

            for (int r = 0; r < EXECUTIONS_PER_TEST; r++)
            {
                System.out.print(getDateTime() + ": Run " + r + "/" + EXECUTIONS_PER_TEST + "\r");
                currentTime = System.nanoTime();
                int steps = 0;
                int plans = 0;
                int rules = 0;
                List<String> fetchs = new ArrayList<String>();

                try {
                    Executor executor = new Executor(PDDLDomain, PDDLProblem, new DijkstraPlanFinder());
                    executor.registerAction("move", new move());
                    executor.registerAction("pickup", new pickup());
                    executor.registerAction("put", new put());
                    Robot.getInstance().initilizeSimulation(PYTHONEXECUTABLE, gymEnv, Integer.toString(agents));
                    
                    for (int x = 0; x < FETCHES; x++) {
                        String itemPosition = null;
                        if(TESTS[testNr][2] != 2) { // for warehouse the items can only be adjacent to a shelf
                            int Y = ran.nextInt(size-2) + 2;
                            List<Integer> Xs = new ArrayList<>();
                            for (int i = 1; i < (size-1); i++) {
                                if(i % 3 == 0 || i % 3 == 1)
                                    Xs.add(i); 
                            }
                            int randomNum = ran.nextInt(Xs.size());
                            itemPosition = "itemat item room_" + Xs.get(randomNum) + "_" + Y;
                        }
                        else {
                            int Y = ran.nextInt(size);
                            int X = ran.nextInt(size);
                            itemPosition = "itemat item room_" + X + "_" + Y;
                        }
                        
                        executor.removePredicate("itemat item room_0_0"); // remove the previously dropped item
                        executor.addPredicate(itemPosition);

                        List<String> goalState = new ArrayList<>();
                        goalState.add("itemat item room_0_0");

                        while (true) {
                            plans += 1;
                            if(executor.execute(goalState))
                                break;
                        }
                        steps += Robot.getInstance().steps;
                        fetchs.add(String.valueOf(Robot.getInstance().steps));
                        Robot.getInstance().steps = 0;
                    }
                    rules = executor.getModel().getRules().size();

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                    System.out.println(getDateTime() + ": Current Steps: " + Robot.getInstance().steps);
                    System.exit(1);
                }

                total_steps += steps;
                total_plans += plans;

                csvWriter.append(r + ", " + (System.nanoTime() - currentTime) + ", " + steps + ", " + plans + ", " + rules + ", ");

                csvWriter.append(String.join(", ", fetchs));
                csvWriter.append("\n");
                csvWriter.flush();
                
                Robot.getInstance().destroySimulation();
            }
            
            long elapsedNanos = System.nanoTime() - startTime;
            System.out.println(getDateTime() + ": Finished " + size + " " + agents + " " + TESTS[testNr][2] + ": " + total_steps/ EXECUTIONS_PER_TEST + " steps, " + total_plans/ EXECUTIONS_PER_TEST + " plans, " + (elapsedNanos / 1000000000.0)/ EXECUTIONS_PER_TEST + " seconds");
            
            csvWriter.close();
        }
    }
}
