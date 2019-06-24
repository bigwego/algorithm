package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int left = 0;
        for (int i = 1; i < m; i++) {
            left = 0;
            for (int j = 0; j < n; j++) {
                dp[j] += left;
                left = dp[j];
            }
        }
        return dp[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            int left = 0;
            for (int j = 0; j < n; j++) {
                dp[j] += left;
                left = dp[j];
            }
        }

        return dp[n - 1];
    }
}
