class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int m = nums.length;
        int[] r_rf = new int[m];
        int[] nr_rf = new int[m];
        int[] r_nf = new int[m];
        int[] nr_nf = new int[m];
        r_rf[0] = nums[0];
        for (int i = 1; i < m; i++) {
            r_rf[i] = nums[i] + nr_rf[i - 1];
            nr_rf[i] = Math.max(r_rf[i - 1], nr_rf[i - 1]);
            r_nf[i] = nums[i] + nr_nf[i - 1];
            nr_nf[i] = Math.max(r_nf[i - 1], nr_nf[i - 1]);
        }
        return Math.max(nr_rf[m - 1], Math.max(r_nf[m - 1], nr_nf[m - 1]));
    }
}
