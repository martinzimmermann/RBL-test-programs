package actions;

import ModelicaSimulation.RoboterSimulations.Robot;
import ModelicaSimulation.RoboterSimulations.Robot.DriveDirection;
import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;

public class rightHalfDrive implements RuleAction {
    @Override
    public boolean execute(Model model) {
        //System.out.println("Right double");
        Robot.getInstance().driveRightHalf();
        return true;
    }

    @Override
    public void repair(Memory memory) {

    }
}
