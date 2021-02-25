package rule;

import java.io.IOException;
import java.util.Map;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.Predicate;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Robot;

public class pickup implements RuleAction {
    @Override
    public boolean execute(Model model, Map<String, String> parameters) {
        return true;
    }

    @Override
    public void repair(Memory memory, Map<String, String> parameters) {
    }
}
