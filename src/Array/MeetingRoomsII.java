/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class MeetingRoomsII {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        int size = intervals.size();
        int[] starts = new int[size], ends = new int[size];
        for (int i = 0; i < size; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int cnt = 0, endPoint = 0;
        for (int i = 0; i < size; i++) {
            if (starts[i] < ends[endPoint]) {
                cnt++;
            } else {
                endPoint++;
            }
        }
        return cnt;
    }
}
