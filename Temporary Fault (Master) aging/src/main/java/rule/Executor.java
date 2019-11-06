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
        rules.add(new InterpreterRule(new actions.firstRule(), new Rule("actions.firstRule", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), null, new Predicate("goal"), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), 0.2, 0.0, 0.0, false, false, 1.0, 0.0, new DiagnosticPosition(1, 0, 1, 36, "->+goalactions.firstRule[0.2,,,1,0]"))));
        rules.add(new InterpreterRule(new actions.secondRule(), new Rule("actions.secondRule", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), null, new Predicate("goal"), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), 0.2, 0.0, 0.0, false, false, 1.0, 0.0, new DiagnosticPosition(2, 0, 2, 37, "->+goalactions.secondRule[0.2,,,1,0]"))));
        rules.add(new InterpreterRule(new actions.thirdRule(), new Rule("actions.thirdRule", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), null, new Predicate("goal"), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{})), 0.2, 0.0, 0.0, false, false, 1.0, 0.0, new DiagnosticPosition(3, 0, 3, 36, "->+goalactions.thirdRule[0.2,,,1,0]"))));
        rules.add(new InterpreterRule(new actions.goal(), new Rule("actions.goal", 1.0, new AlphaList(new ArrayList<AlphaEntry>(Arrays.asList(new AlphaEntry[]{})), new AlphaEntry("0 <= a <= 1",null,(a) -> new BigDecimal(1))), new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal")})), "goal", null, new ArrayList<Predicate>(Arrays.asList(new Predicate[]{new Predicate("goal")})), 0.1, 0.0, 0.0, false, false, 1.0, 1.0, new DiagnosticPosition(4, 0, 4, 28, "goal->#goal-goalactions.goal"))));


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

        boolean success = interpretRules(model, plan);

        for (Rule rule : model.getRules()) {
            if(plan.contains(rule))
                rule.increaseActivity();
            else
                rule.decreaseActivity();
            rule.ageRule();
        }
        return success;
    }

    private boolean interpretRules(Model model, List<InterpreterRule> plan) {

        for (InterpreterRule rule : plan) {
            boolean result = rule.execute(model);
            if (result) {
                model.getMemory().update(rule);
                rule.decreaseDamping();
            } else {
                rule.repairMemory(model.getMemory());
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
