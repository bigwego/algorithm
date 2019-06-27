package DynamicProgramming;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }

    public int maximalSquare3(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        int max = 0, pre = 0;

        for (int i = 1; i <= m; i++) {
            pre = 0;
            for (int j = 1; j <= n; j++) {
                int tmp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = 1 + Math.min(pre, Math.min(dp[j], dp[j - 1]));
                    max = Math.max(max, dp[j]);
                } else dp[j] = 0;
                pre = tmp;
            }
        }

        return max * max;
    }
}
