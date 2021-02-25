package rule;

import java.io.IOException;
import java.util.Map;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.Predicate;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Robot;

public class move implements RuleAction {
    @Override
    public boolean execute(Model model, Map<String, String> parameters) {
        String[] from = parameters.get("?from").replace("room_", "").split("_");
        String[] to = parameters.get("?to").replace("room_", "").split("_");

        int[] from_pos = new int[2];
        from_pos[0] = Integer.parseInt(from[0]);
        from_pos[1] = Integer.parseInt(from[1]);

        int[] to_pos = new int[2];
        to_pos[0] = Integer.parseInt(to[0]);
        to_pos[1] = Integer.parseInt(to[1]);
        boolean success;
        //System.out.print("move from:" + from_pos[0] + "/" + from_pos[1] + " to:" + to_pos[0] + "/" + to_pos[1] + " ");
        try {
            if(from_pos[0] + 1 == to_pos[0]&& from_pos[1] == to_pos[1]) {
                //System.out.print("E");
                success = Robot.getInstance().driveE();
            }
            else if(from_pos[0] - 1 == to_pos[0] && from_pos[1] == to_pos[1]){
                //System.out.print("W");
                success = Robot.getInstance().driveW();
            }
            else if (from_pos[0] == to_pos[0] && from_pos[1] - 1 == to_pos[1]) {
                //System.out.print("N");
                success = Robot.getInstance().driveN();
            }
            else if(from_pos[0] == to_pos[0] && from_pos[1] + 1 == to_pos[1]){
                //System.out.print("S");
                success = Robot.getInstance().driveS();
            }
            else {
                success = false;
                //System.out.print("Room not connected");
                assert(false);
            }
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }
        //System.out.println((success ? " successfull" : " fail"));
        return success;
    }

    @Override
    public void repair(Memory memory, Map<String, String> parameters) {
        //memory.remove("at " + parameters.get("from"));
        //memory.add("at room_0_0");
        //Robot.getInstance().reset()
    }
}
