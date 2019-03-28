class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
			return 0;
		}
        int n = prices.length;
        if (k >=  n/2) {
		int maxPro = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i-1])
				maxPro += prices[i] - prices[i-1];
		}
		return maxPro;
	}
		int[][] dp = new int[k + 1][prices.length];
		for (int i = 1; i <= k; i++) {
			int diff = dp[i - 1][0] - prices[0];
			for (int j = 1; j < prices.length; j++) {
				dp[i][j] = dp[i][j - 1];
				diff = Math.max(diff, dp[i - 1][j - 1] - prices[j - 1]);
				dp[i][j] = Math.max(dp[i][j], prices[j] + diff);
			}
		}
		return dp[k][prices.length - 1];
    }
}
