package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
// Problem 56
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval arg0, Interval arg1) {
                return arg0.start - arg1.start;
            }

        });
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval it = intervals.get(i);
            if (it.start <= end) {
                end = Math.max(end, it.end);
            } else {
                res.add(new Interval(start, end));
                start = it.start;
                end = it.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1, len = intervals.length; i < len; i++) {
            int s = intervals[i][0];
            if (s <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[]{ start, end });
                start = s;
                end = intervals[i][1];
            }
        }

        res.add(new int[]{ start, end });
        int[][] ret = new int[res.size()][2];
        for (int i = 0, len = ret.length; i < len; i++)
            ret[i] = res.get(i);

        return ret;
    }

    public int[][] merge3(int[][] intervals) {
        List<int[]> res = new ArrayList();
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (i == intervals.length - 1 || starts[i + 1] > ends[i]) {
                res.add(new int[]{ starts[j], ends[i] });
                j = i + 1;
            }
        }
        return res.toArray(new int[0][]);
    }
}
