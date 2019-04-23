package Array;

public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, zeros = 0, i = 0;
        for (int j = 0, len = nums.length; j < len; j++) {
            if (nums[j] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[i++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
