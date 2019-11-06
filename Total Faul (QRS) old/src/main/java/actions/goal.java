package actions;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Results;
import simulation.Simulation;

import java.io.IOException;

public class goal implements RuleAction {
    @Override
    public boolean execute(Memory memory) {
        Simulation.objectDetected++;
        //System.out.println("Object detected");
        return true;
    }

    @Override
    public void repair(Memory memory) {

    }
}
