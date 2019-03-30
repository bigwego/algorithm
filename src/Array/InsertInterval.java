package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        int i = 0;
        int size = intervals.size();
        while (i < size && intervals.get(i).end < start) {
            res.add(intervals.get(i++));
        }
        while (i < size && intervals.get(i).start <= end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i++).end);
        }
        res.add(new Interval(start, end));
        while (i < size) {
            res.add(intervals.get(i++));
        }
        return res;
    }

    private class Interval {
        int start;

        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
