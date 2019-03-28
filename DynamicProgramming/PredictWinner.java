class PredictWinner {
    public boolean PredictTheWinner(int[] nums) {
        int m = nums.length;
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < m; len++) {
            for (int i = 0; i + len < m; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][m - 1] >= 0;
    }
}
