class MaximumSubarray {
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
}
