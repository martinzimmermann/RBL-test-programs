package simulation;

import at.tugraz.ist.compiler.interpreter.BestPlanFinder;
import at.tugraz.ist.compiler.interpreter.NoPlanFoundException;
import rule.Executor;

public class Simulation {

    public static int objectDetected = 0;

    public static void main(String[] args) {
        System.out.println("\u001B[32mStarting Simulation...\u001B[0m");
        for (int i = 0; i < 1; i++) {
            Executor executor = null;
            try {
                executor = new Executor(new BestPlanFinder());
                executor.executesNTimes(Environment.getInstance().GetWeatherConditionsLeft());
                Environment.getInstance().reset();
            } catch (ClassNotFoundException e) {
                assert false;
            } catch (NoPlanFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Successes %: " + (1.0 * objectDetected) / (4000));
    }
}