package actions;

import at.tugraz.ist.compiler.interpreter.Memory;
import at.tugraz.ist.compiler.interpreter.Model;
import at.tugraz.ist.compiler.rule.RuleAction;
import simulation.Environment;
import simulation.Results;
import simulation.Segment;

import java.io.IOException;

public class thirdRule implements RuleAction {
    @Override
    public boolean execute(Memory memory) {
        //System.out.println("Trying to detect Object with Third");
        Segment.Rule rule = Segment.Rule.Third;
        boolean success = Environment.getInstance().getNextSegement().IsExecutionSuccessful(rule);
        //try {
        //    Results.getInstance().writeAll(rule, success, model);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        return success;
    }

    @Override
    public void repair(Memory memory) {

    }
}
