package rule;
import at.tugraz.ist.compiler.*;
import at.tugraz.ist.compiler.interpreter.*;
import at.tugraz.ist.compiler.rule.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Executor extends LibExecutor {

    static Model generateModel() throws ClassNotFoundException {
        Arrays.asList(); // Just so the import won't get removed at a code cleanup
        new BigDecimal(0); // Just so the import won't get removed at a code cleanup
        List<Rule> rules = new ArrayList<>();
        rules.add(new InterpreterRule(new actions.firstRule(), new Rule("actions.firstRule", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(1, 0, 1, 17, "->+goalactions.firstRule"))));
        rules.add(new InterpreterRule(new actions.secondRule(), new Rule("actions.secondRule", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(2, 0, 2, 17, "->+goalactions.secondRule"))));
        rules.add(new InterpreterRule(new actions.thirdRule(), new Rule("actions.thirdRule", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(3, 0, 3, 17, "->+goalactions.thirdRule"))));
        rules.add(new InterpreterRule(new actions.goal(), new Rule("actions.goal", "goal", new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal", true)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal", false)})), new DiagnosticPosition(4, 0, 4, 28, "goal->#goal-goalactions.goal"))));


        List<Predicate> predicates = new ArrayList<>();


        Memory memory = new Memory(predicates);
        Model model = new Model(memory, rules);
        if(ErrorHandler.Instance().hasErrors()) {
            ErrorHandler.Instance().printErrorCount();
            throw new ClassNotFoundException();
        }
        return model;
    }

    public Executor(PlanFinder planFinder) throws ClassNotFoundException {
        super(generateModel(), planFinder);
    }

}