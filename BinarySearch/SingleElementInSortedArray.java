class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, hi = nums.length - 1;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] != nums[mid + 1]) hi = mid;
            else low = mid + 2;
        }
        return nums[low];
    }
}
