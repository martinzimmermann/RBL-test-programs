package actions;

import ModelicaSimulation.RoboterSimulations.Robot;
import ModelicaSimulation.RoboterSimulations.Robot.DriveDirection;
import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;

public class drive implements RuleAction {
    @Override
    public boolean execute(Model model) {
        //System.out.println("Drive");
        return Robot.getInstance().getDrivingDirection() == DriveDirection.Straight;
    }

    @Override
    public void repair(Memory memory) {
        memory.remove("configure");
    }
}
