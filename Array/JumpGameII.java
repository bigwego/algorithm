class JumpGameII {
    public int jump(int[] nums) {
        if(nums==null||nums.length<2) {
            return 0;
        }
        int currMax = 0, max = 0, i = 0, step = 0;
		while (currMax >= i) {
			step++;
			for (; i <= currMax; i++) {
				max = Math.max(max, i + nums[i]);
				if (max >= nums.length - 1) {
					return step;
				}
			}
			currMax = max;
		}
		return step;
    }
}
