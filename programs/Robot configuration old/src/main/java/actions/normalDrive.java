package actions;

import ModelicaSimulation.RoboterSimulations.Robot;
import ModelicaSimulation.RoboterSimulations.Robot.DriveDirection;
import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;

public class normalDrive implements RuleAction {
    @Override
    public boolean execute(Memory memory) {
        //System.out.println("Normal drive");
        Robot.getInstance().driveNormal();
        return true;
    }

    @Override
    public void repair(Memory memory) {

    }
}
