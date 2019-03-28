class decreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i - 1] > nums[i]) {
                if (cnt++ > 0) return false;
                if (i >= 2 && nums[i - 2] > nums[i])
                    nums[i] = nums[i - 1];
                else nums[i - 1] = nums[i];
            }
        }
        return true;
    }
}
