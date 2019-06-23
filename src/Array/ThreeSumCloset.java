package Array;

import java.util.Arrays;

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

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);

        int res = 0, diff = Integer.MAX_VALUE;

        for (int i = 0, len = nums.length; i < len - 2; i++) {
            int l = i + 1, r = len - 1;
            int sum = 0;
            while (l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < diff) {
                    res = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum > target) r--;
                else l++;
            }
        }

        return res;
    }

}
