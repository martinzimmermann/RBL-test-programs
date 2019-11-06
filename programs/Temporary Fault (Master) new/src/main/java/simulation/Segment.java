package simulation;

import java.util.Random;

public abstract class Segment {

    abstract int GetFirstRuleSuccessPercentage();

    abstract int GetSecondRuleSuccessPercentage();

    abstract int GetThirdRuleSuccessPercentage();

    public boolean IsExecutionSuccessful(Rule rule) {

        Random rnd = new Random();
        int number = rnd.nextInt(100);
        boolean successful = false;

        switch (rule) {
            case First:
                successful = number <= GetFirstRuleSuccessPercentage();
                break;
            case Second:
                successful =  number <= GetSecondRuleSuccessPercentage();
                break;
            case Third:
                successful =  number <= GetThirdRuleSuccessPercentage();
                break;
        }
        return successful;
    }

    public enum Rule {First, Second, Third}
}
