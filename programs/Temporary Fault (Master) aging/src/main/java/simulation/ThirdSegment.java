package simulation;

public class ThirdSegment extends Segment {

    @Override
    public int GetFirstRuleSuccessPercentage() {
        return 0;
    }

    @Override
    public int GetSecondRuleSuccessPercentage() {
        return 0;
    }

    @Override
    public int GetThirdRuleSuccessPercentage() {
        return 100;
    }
}