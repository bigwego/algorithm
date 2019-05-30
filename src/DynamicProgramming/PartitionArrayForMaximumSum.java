package DynamicProgramming;

public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int len = A.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            int currMax = 0;
            for (int k = 1; k <= K && i >= k - 1; k++) {
                currMax = Math.max(currMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], ((i >= k) ? dp[i - k] : 0) + k * currMax);
            }
        }

        return dp[len - 1];
    }
}
