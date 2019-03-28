import java.util.Arrays;

/**
 * @author: ZHANG
 * @description:
 * @create: 2019/03/28
 **/
public class ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) < Math.abs(diff)) {
                    res = nums[i] + nums[lo] + nums[hi];
                    diff = res - target;
                }
                if (nums[i] + nums[lo] + nums[hi] > target) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return res;
    }


}
