package SlidingWindow;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, res = Integer.MIN_VALUE;
        for (int i = 0, len = nums.length; i < len; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                sum -= i == k - 1 ? 0 : nums[i - k];
                res = Math.max(res, sum / k);
            }
        }
        return res;
    }
}
