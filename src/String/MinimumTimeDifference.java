package String;

import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] splits = time.split(":");
            int h = Integer.valueOf(splits[0]);
            int m = Integer.valueOf(splits[1]);
            int idx = 60 * h + m;
            if (minutes[idx]) {
                return 0;
            }
            minutes[idx] = true;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, diff = Integer.MAX_VALUE, prev = 0;
        for (int i = 0; i < minutes.length; i++) {
            if (minutes[i]) {
                if (min != Integer.MAX_VALUE) {
                    diff = Math.min(diff, i - prev);
                }
                prev = i;
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        return Math.min(diff, (24 * 60 + min - max));
    }
}
