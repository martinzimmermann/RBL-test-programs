package simulation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Environment {
    private static Environment ourInstance = new Environment();

    private static int[] battery_charge = new int[]{0, 80};
    private static boolean[] bulb_broken = new boolean[]{true, false};

    private static int battery_selected = -1;
    private static int bulb_selected = -1;

    private static int step = 0;
    private Environment() {
    }

    public void reset() {
        battery_charge = new int[]{0, 80};
        bulb_broken = new boolean[]{true, false};
        step = 0;
    }

    public static void step() {
        if (step == 75){
            battery_charge[0] = 80;
            battery_charge[1] = 80;
        }

        if (step == 150)
            bulb_broken[0] = false;

        if (step == 175)
            bulb_broken[1] = true;

        if (step == 220) {
            battery_charge[1] = 80;
            battery_charge[0] = 80;
        }
        
        step++;
    }

    public static Environment getInstance() {
        return ourInstance;
    }

    public static void selectBulb(int i) {
        bulb_selected = i;
    }

    public static void selectBattery(int i) {
        battery_selected = i;
    }

    public static boolean turnOn() {
        boolean success = true;
        if(bulb_selected == -1 || battery_selected == -1)
            assert(false);

        step();
        
        if(battery_charge[battery_selected] == 0)
            success = false;

        if(bulb_broken[bulb_selected] == true)
            success = false;

        
        battery_charge[battery_selected] = battery_charge[battery_selected] == 0 ? 0 : battery_charge[battery_selected]-1 ;
        
        battery_selected = -1;
        bulb_selected = -1;
        return success;
    }

}
