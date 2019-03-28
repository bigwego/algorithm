class UniquePaths {
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
}
