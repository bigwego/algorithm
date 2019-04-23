package Quiz;

import java.util.Arrays;

public class MinimumMovesEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        int i = 0, j = nums.length - 1, res = 0;
        Arrays.sort(nums);
        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }
}