package DynamicProgramming;

import java.util.HashMap;

public class LongestArithmeticSequence {

    public int longestArithSeqLength(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }

        int len = A.length;
        int res = 2;
        HashMap<Integer, Integer>[] dp = new HashMap[len];
        dp[0] = new HashMap<>();
        for (int i = 1; i < len; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                Integer prev = dp[i - 1].get(diff);
                if (prev != null) {
                    dp[i].put(diff, prev + 1);
                } else {
                    dp[i].put(diff, 2);
                }
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}
