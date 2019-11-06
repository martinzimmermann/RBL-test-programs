package simulation;

public class SecondSegment extends Segment {

    @Override
    public int GetFirstRuleSuccessPercentage() {
        return 0;
    }

    @Override
    public int GetSecondRuleSuccessPercentage() {
        return 100;
    }

    @Override
    public int GetThirdRuleSuccessPercentage() {
        return 100;
    }
}
