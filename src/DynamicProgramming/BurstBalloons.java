class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int left = i == 0 ? 1 : nums[i - 1];
                    int right = j == nums.length - 1 ? 1 : nums[j + 1];
                    int before = k == i ? 0 : dp[i][k - 1];
                    int after = k == j ? 0 : dp[k + 1][j];
                    dp[i][j] = Math.max(dp[i][j], left * nums[k] * right + before + after);
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
