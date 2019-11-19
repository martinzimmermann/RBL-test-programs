package actions;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Environment;

import java.io.IOException;

public class useBattery1 implements RuleAction {
    @Override
    public boolean execute(Model model) {
        Environment.getInstance().selectBattery(0);
        return true;
    }

    @Override
    public void repair(Memory memory) {

    }
}