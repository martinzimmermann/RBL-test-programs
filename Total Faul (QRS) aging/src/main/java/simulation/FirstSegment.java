package simulation;

public class FirstSegment extends Segment {

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
