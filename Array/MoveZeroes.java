class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int rec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[rec++] = nums[i];
            }
        }
        while (rec < nums.length) {
            nums[rec++] = 0;
        }
    }
}
