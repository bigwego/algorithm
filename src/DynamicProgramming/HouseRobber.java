class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int r = nums[0], nr = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = r;
            r = nr + nums[i];
            nr = Math.max(tmp, nr);
        }
        return Math.max(r, nr);
    }
}
