class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1, len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int tmp = i;
            while (i < len - 1 && nums[i] < nums[i + 1]) i++;
            res = Math.max(res, i - tmp + 1);
        }
        return res;
    }
}
