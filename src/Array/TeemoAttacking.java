package Array;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }
        int res = duration;
        for (int i = 1, len = timeSeries.length; i < len; i++) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            res += Math.min(diff, duration);
        }
        return res + duration;
    }
}
