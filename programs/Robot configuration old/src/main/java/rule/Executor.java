package rule;

import at.tugraz.ist.compiler.*;
import at.tugraz.ist.compiler.interpreter.*;
import at.tugraz.ist.compiler.rule.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Executor {

    private Model model;
    private final PlanFinder planFinder;

    public Executor(PlanFinder planFinder) throws ClassNotFoundException {
        this.planFinder = planFinder;
        Arrays.asList(); // Just so the import won't get removed at a code cleanup
        new BigDecimal(0); // Just so the import won't get removed at a code cleanup
        List<Rule> rules = new ArrayList<>();
        rules.add(new InterpreterRule(new actions.leftHalfDrive(), new Rule("actions.leftHalfDrive", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), null, new Predicate("configure"), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(1, 0, 1, 22, "->+configureactions.leftHalfDrive"))));
        rules.add(new InterpreterRule(new actions.rightHalfDrive(), new Rule("actions.rightHalfDrive", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), null, new Predicate("configure"), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(2, 0, 2, 22, "->+configureactions.rightHalfDrive"))));
        rules.add(new InterpreterRule(new actions.normalDrive(), new Rule("actions.normalDrive", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), null, new Predicate("configure"), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), new DiagnosticPosition(3, 0, 3, 22, "->+configureactions.normalDrive"))));
        rules.add(new InterpreterRule(new actions.drive(), new Rule("actions.drive", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure")})), "drive", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("configure")})), new DiagnosticPosition(4, 0, 4, 39, "configure->#drive-configureactions.drive"))));


        List<Predicate> predicates = new ArrayList<>();


        Memory memory = new Memory(predicates);
        model = new Model(memory, rules);
        if(ErrorHandler.Instance().hasErrors()) {
            ErrorHandler.Instance().printErrorCount();
            throw new ClassNotFoundException();
        }
    }

    public boolean executesTillGoalReached() throws NoPlanFoundException {
        return executesTillGoalReached(10);
    }

    private boolean executesTillGoalReached(int limit) throws NoPlanFoundException {
        for (int i = 0; i < limit; i++) {
            if (executeOnce())
                return true;
        }
        return false;
    }

    public boolean executeOnce() throws NoPlanFoundException {
        List<Rule> rules = toRules(model.getRules());
        List<InterpreterRule> goals = toInterpreterRules(planFinder.getGoalRules(rules));
        Memory memory = model.getMemory();

        List<InterpreterRule> plan = null;
        goals.sort(Rule::compareTo);
        for (Rule goal : goals) {
            plan = toInterpreterRules(planFinder.getAnyPlan(memory, rules));
            if (plan != null)
                break;
        }
        if (plan == null)
            throw new NoPlanFoundException();

        boolean success = interpreteRules(memory, plan);

        for (Rule rule : model.getRules()) {
            if(plan.contains(rule))
                rule.increaseActivity();
            else
                rule.decreaseActivity();
        }
        return success;
    }

    private boolean interpreteRules(Memory memory, List<InterpreterRule> plan) {

        for (InterpreterRule rule : plan) {
            boolean result = rule.execute(memory);
            if (result) {
                memory.update(rule);
                rule.decreaseDamping();
            } else {
                rule.repairMemory(memory);
                rule.increaseDamping();
                return false;
            }
        }
        return true;
    }

    private List<InterpreterRule> toInterpreterRules(List<Rule> goalRules) {
        return goalRules == null ? null : goalRules.stream().map(r -> (InterpreterRule) r).collect(Collectors.toList());
    }

    private List<Rule> toRules(List<InterpreterRule> rules) {
        return rules == null ? null : rules.stream().collect(Collectors.toList());
    }

    public void executesNTimes(int n) throws NoPlanFoundException {
        for (int i = 0; i < n; i++) {
            executeOnce();
        }
    }

    public void executesForever() throws NoPlanFoundException {
        while (true) {
            executeOnce();
        }
    }

    public void resetMemory() {
        model.getMemory().reset();
    }

    public List<String> getMemory() {
        return new ArrayList<>(model.getMemory().getAllPredicates().stream().map(Predicate::toString).collect(Collectors.toList()));
    }

}
