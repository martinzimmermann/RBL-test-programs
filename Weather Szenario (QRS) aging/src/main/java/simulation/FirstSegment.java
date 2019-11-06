package simulation;

public class FirstSegment extends Segment {

    @Override
    public int GetFirstRuleSuccessPercentage() {
        return 100;
    }

    @Override
    public int GetSecondRuleSuccessPercentage() {
        return 80;
    }

    @Override
    public int GetThirdRuleSuccessPercentage() {
        return 70;
    }
}
