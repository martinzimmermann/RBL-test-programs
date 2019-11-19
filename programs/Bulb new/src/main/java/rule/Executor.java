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
        rules.add(new InterpreterRule(new actions.useBattery1(), new Rule("actions.useBattery1", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("bat", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(1, 0, 1, 16, "->+batactions.useBattery1"))));
        rules.add(new InterpreterRule(new actions.useBattery2(), new Rule("actions.useBattery2", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("bat", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(2, 0, 2, 16, "->+batactions.useBattery2"))));
        rules.add(new InterpreterRule(new actions.useBulb1(), new Rule("actions.useBulb1", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("bulb", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(3, 0, 3, 17, "->+bulbactions.useBulb1"))));
        rules.add(new InterpreterRule(new actions.useBulb2(), new Rule("actions.useBulb2", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("bulb", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(4, 0, 4, 17, "->+bulbactions.useBulb2"))));
        rules.add(new InterpreterRule(new actions.switchOn(), new Rule("actions.switchOn", "glow", new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("bat", true), new Predicate("bulb", true)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("bat", false), new Predicate("bulb", false)})), new DiagnosticPosition(5, 0, 5, 38, "bat,bulb->#glow-bat-bulbactions.switchOn"))));


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