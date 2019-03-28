class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int end = -2, beg = -1, n = nums.length, max = nums[0], min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (max > nums[i]) end = i;
            if (min < nums[n - 1 - i]) beg = n - 1 - i;
        }
        return end - beg + 1;
    }
}
