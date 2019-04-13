package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        int[] cnts = new int[len];
        int[] pre = new int[len];
        Arrays.fill(cnts, 1);
        Arrays.fill(pre, -1);
        Arrays.sort(nums);
        int idx = 0, max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (1 + cnts[j] > cnts[i]) {
                        max = 1 + cnts[j];
                        pre[i] = j;
                    }
                }
            }
            if (cnts[i] > max) {
                max = cnts[i];
                idx = i;
            }
        }
        while (idx != -1) {
            res.add(nums[idx]);
            idx = pre[idx];
        }
        return res;
    }
}
