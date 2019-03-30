package DynamicProgramming;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum < S || (sum + S) % 2 != 0 ? 0 : help(nums, (sum + S) >>> 1);
    }

    private int help(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
