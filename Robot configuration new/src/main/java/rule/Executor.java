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
        rules.add(new InterpreterRule(new actions.leftHalfDrive(), new Rule("actions.leftHalfDrive", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(1, 0, 1, 22, "->+configureactions.leftHalfDrive"))));
        rules.add(new InterpreterRule(new actions.rightHalfDrive(), new Rule("actions.rightHalfDrive", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(2, 0, 2, 22, "->+configureactions.rightHalfDrive"))));
        rules.add(new InterpreterRule(new actions.normalDrive(), new Rule("actions.normalDrive", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure", false)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(3, 0, 3, 22, "->+configureactions.normalDrive"))));
        rules.add(new InterpreterRule(new actions.drive(), new Rule("actions.drive", "drive", new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure", true)})), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure", false)})), new DiagnosticPosition(4, 0, 4, 39, "configure->#drive-configureactions.drive"))));


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