package actions;

import ModelicaSimulation.RoboterSimulations.Robot;
import ModelicaSimulation.RoboterSimulations.Robot.DriveDirection;
import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;

public class leftHalfDrive implements RuleAction {
    @Override
    public boolean execute(Memory memory) {
        //System.out.println("Left double");
        Robot.getInstance().driveLeftHalf();
        return Robot.getInstance().getDrivingDirection() == DriveDirection.Straight;
    }

    @Override
    public void repair(Memory memory) {

    }
}
