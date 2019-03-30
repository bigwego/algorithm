package Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num + 1;
                while (set.contains(curr)) {
                    curr++;
                }
                res = Math.max(res, curr - num);
            }
        }
        return res;
    }
}
