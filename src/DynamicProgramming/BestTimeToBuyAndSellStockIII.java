package DynamicProgramming;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = 2;
        int[][] dp = new int[n + 1][prices.length];
        for (int i = 1; i <= n; i++) {
            int diff = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = dp[i][j - 1];
                diff = Math.max(diff, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j], prices[j] + diff);
            }
        }
        return dp[n][prices.length - 1];
    }
}
