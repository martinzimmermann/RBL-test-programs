package actions;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Environment;
import simulation.Simulation;

import java.io.IOException;

public class switchOn implements RuleAction {
    @Override
    public boolean execute(Model model) {
        boolean success = Environment.getInstance().turnOn();
        if (success)
            Simulation.successes ++;
        return success;
    }

    @Override
    public void repair(Memory memory) {
        memory.remove("bat");
        memory.remove("bulb");
    }
}
