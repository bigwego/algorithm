package DynamicProgramming;

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        if (n == 1) {
            int res = 0;
            for (int i = 0; i < m; i++) {
                res += A[i][0];
            }
            return res;
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }
        return res;
    }
}