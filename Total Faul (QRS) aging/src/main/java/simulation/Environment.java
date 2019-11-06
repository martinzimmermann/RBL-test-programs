package simulation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Environment {
    private static Environment ourInstance = new Environment();
    private Deque<Segment> conditions;

    private Environment() {
        conditions = new ArrayDeque<>();
        addMultiple(new FirstSegment(), 1000);
        addMultiple(new SecondSegment(), 1000);
        addMultiple(new ThirdSegment(), 1000);
        addMultiple(new FirstSegment(), 1000);
    }

    public void reset() {
        conditions = new ArrayDeque<>();
        addMultiple(new FirstSegment(), 1000);
        addMultiple(new SecondSegment(), 1000);
        addMultiple(new ThirdSegment(), 1000);
        addMultiple(new FirstSegment(), 1000);
    }

    public int GetWeatherConditionsLeft()
    {
        return conditions.size();
    }

    public static Environment getInstance() {
        return ourInstance;
    }

    public Segment getNextSegement() {
        return conditions.poll();
    }

    private void addMultiple(Segment condition, int times) {
        for (int i = 0; i < times; i++) {
            conditions.offer(condition);
        }
    }
}
