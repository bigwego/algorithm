package Array;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMax = max * nums[i];
            int currMin = min * nums[i];
            max = Math.max(nums[i], Math.max(currMax, currMin));
            min = Math.min(nums[i], Math.min(currMax, currMin));
            res = Math.max(res, max);
        }
        return res;
    }
}
