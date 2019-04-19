package DynamicProgramming;

public class GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return help(dp, 1, n);
    }

    private int help(int[][] dp, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            res = Math.min(res, x + Math.max(help(dp, i, x - 1), help(dp, x + 1, j)));
        }
        dp[i][j] = res;
        return res;
    }
}
