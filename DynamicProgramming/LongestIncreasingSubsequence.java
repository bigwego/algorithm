class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] tails = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int left = 0, right = len;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (num <= tails[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			tails[left] = num;
			if(left==len){
				len++;
			}
		}
		return len;
    }
}
