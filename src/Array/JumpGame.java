class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
			return true;
		}
		int max = nums[0], i = 0;
		while (max >= i) {
			max = Math.max(i + nums[i], max);
			if (max >= nums.length - 1) {
				return true;
			}
            i++;
		}
		return false;
    }
}
