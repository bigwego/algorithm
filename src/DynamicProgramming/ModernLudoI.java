package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModernLudoI {

    public int modernLudo(int length, int[][] connections) {
        int[] dp = new int[length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] conn : connections) {
            map.put(conn[0], conn[1]);
        }
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 2; i <= length; i++) {
            if (i <= 7) {
                dp[i] = 1;
            } else {
                for (int j = i - 1; j > i - 7; j--) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
            if (map.containsKey(i)) {
                dp[map.get(i)] = Math.min(dp[i], dp[map.get(i)]);
            }
        }

        return dp[length];
    }
}
