class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, from = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (from <= i && sum >= s) {
				res = Math.min(res, i - from + 1);
                sum -= nums[from];
				from++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
    }
}
