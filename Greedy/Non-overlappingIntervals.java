/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Non-overlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            return o1.end - o2.end;
        });
        int cnt = 1, end = intervals[0].end;
        for (Interval it : intervals) {
            if (it.start >= end) {
                cnt++;
                end = it.end;
            }
        }
        return intervals.length - cnt;
    }
}
