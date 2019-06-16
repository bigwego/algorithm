package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestValuesFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[][] pairs = new int[values.length][2];
        for (int i = 0, len = pairs.length; i < len; i++) {
            pairs[i] = new int[]{ values[i], labels[i] };
        }
        Arrays.sort(pairs, (p1, p2) -> p2[0] - p1[0]);

        Map<Integer, Integer> cnts = new HashMap<>();
        int sum = 0, cnt = 0;

        for (int i = 0, len = pairs.length; i < len; i++) {
            if (!cnts.containsKey(pairs[i][1])) {
                sum += pairs[i][0];
                cnts.put(pairs[i][1], 1);
            } else {
                if (cnts.get(pairs[i][1]) == use_limit) continue;
                sum += pairs[i][0];
                cnts.put(pairs[i][1], cnts.get(pairs[i][1]) + 1);
            }
            if (++cnt == num_wanted) break;
        }

        return sum;
    }
}
