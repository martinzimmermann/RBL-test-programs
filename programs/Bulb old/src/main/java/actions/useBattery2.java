package actions;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Environment;

import java.io.IOException;

public class useBattery2 implements RuleAction {
    @Override
    public boolean execute(Memory memory) {
        Environment.getInstance().selectBattery(1);
        return true;
    }

    @Override
    public void repair(Memory memory) {

    }
}
