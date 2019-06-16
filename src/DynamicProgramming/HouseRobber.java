package DynamicProgramming;

public class HouseRobber {

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

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int r = nums[0], nr = 0;

        for (int i = 1; i < len; i++) {
            int tmp = r;
            r = nr + nums[i];
            nr = Math.max(nr, tmp);
        }

        return Math.max(r, nr);
    }
}
