package DynamicProgramming;

public class DeleteOperationForTwoStrings {

    public int minDistance(final String word1, final String word2) {
        final int m = word1.length();
        final int n = word2.length();
        final int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ?
                                            dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
