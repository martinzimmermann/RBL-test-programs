package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Robot {
    // ACTION = ["N", "S", "E", "W"]
    private static final Robot instance = new Robot();

    private Robot() {
    }

    int[] pos = new int[2];
    private BufferedReader in;
    private BufferedWriter out;
    private Process p;
    public int steps = 0;

    public void initilizeSimulation(String pythonExecutable, String gymEnv, String numActors) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(pythonExecutable, "../Python/main.py", gymEnv, numActors);
        this.p = pb.start();
        this.in = new BufferedReader(new InputStreamReader(this.p.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(this.p.getOutputStream()));
        this.in.readLine();
        this.in.readLine();

        reset();
        steps = 0;
    }

    public void destroySimulation() {
        this.p.destroyForcibly();
        this.p = null;
        this.in = null;
        this.out = null;
    }

    public void reset() throws IOException {
        pos = getCurrentPositon();
    }

    // public static GeorgsRoboterSimulation getInstance(){
    public static Robot getInstance() {
        return instance;
    }

    public boolean driveSample() throws IOException {
        boolean success = true;
        switch(new Random().nextInt(4)) {
            case 0:
                success = driveN();
                break;
            case 1:
                success = driveE();
                break;
            case 2:
                success = driveS();
                break;
            case 3:
                success = driveW();
                break;
        }
        return success;
    }

    public boolean driveN() throws IOException {
        out.write("0\n");
        out.flush();
        return updatedPosition();
    }

    public boolean driveE() throws IOException {
        out.write("2\n");
        out.flush();
        return updatedPosition();
    }

    public boolean driveS() throws IOException {
        out.write("1\n");
        out.flush();
        return updatedPosition();
    }

    public boolean driveW() throws IOException {
        out.write("3\n");
        out.flush();
        return updatedPosition();
    }

    public int[] getPostiton(){
        return pos;
    }

    private boolean updatedPosition() throws IOException {
        steps++;
        int[] temp = getCurrentPositon();
        boolean fail = (temp[0] == pos[0] && temp[1] == pos[1]);
        pos = temp;
        return !fail;
    }

    private int[] getCurrentPositon() throws IOException {
        int[] temp = new int[2];
        String first_coord = in.readLine();
        first_coord = first_coord.replace("[", "");
        first_coord = first_coord.replace("]", "");
        first_coord = first_coord.replace(".", "");
        String[] coord = first_coord.split(" ");
        temp[0] = Integer.parseInt(coord[0]);
        temp[1] = Integer.parseInt(coord[1]);
        return temp;
    }
}