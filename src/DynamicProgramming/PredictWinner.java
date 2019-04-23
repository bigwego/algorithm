package DynamicProgramming;

public class PredictWinner {

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

    public boolean PredictTheWinner2(int[] nums) {
        return help(nums, 0, nums.length - 1) >= 0;
    }

    private int help(int[] nums, int i, int j) {
        return i == j ? nums[i] : Math.max(nums[i] - help(nums, i + 1, j), nums[j] - help(nums, i, j - 1));
    }
}
