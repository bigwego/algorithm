package Others;

public class RandomPickIndex {

    private java.util.Random rand;

    private final int[] nums;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        rand = new java.util.Random();
    }

    public int pick(int target) {
        int res = -1, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (rand.nextInt(++cnt) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
