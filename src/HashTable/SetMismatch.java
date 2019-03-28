class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] > 0)
                nums[Math.abs(num) - 1] *= -1;
            else
                res[0] = Math.abs(num);
        }
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }
}
