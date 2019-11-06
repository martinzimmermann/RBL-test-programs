package simulation;

public class ThirdSegment extends Segment {

    @Override
    public int GetFirstRuleSuccessPercentage() {
        return 45;
    }

    @Override
    public int GetSecondRuleSuccessPercentage() {
        return 60;
    }

    @Override
    public int GetThirdRuleSuccessPercentage() {
        return 70;
    }
}
