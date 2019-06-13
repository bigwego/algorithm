package Array;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            res = Math.max(sum, res);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 1;
        int sum = Integer.MIN_VALUE;
        int i = 0;

        for (int j = 0, len = nums.length; i < len; i++) {
            sum += nums[j];
            res = Math.max(res, sum);
            if (sum < 0) {
                i = j + 1;
                sum = 0;
            }
        }

        return res;
    }
}
