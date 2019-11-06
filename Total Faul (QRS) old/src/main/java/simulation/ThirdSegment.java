package simulation;

public class ThirdSegment extends Segment {

    @Override
    public int GetFirstRuleSuccessPercentage() {
        return 100;
    }

    @Override
    public int GetSecondRuleSuccessPercentage() {
        return 100;
    }

    @Override
    public int GetThirdRuleSuccessPercentage() {
        return 0;
    }
}
