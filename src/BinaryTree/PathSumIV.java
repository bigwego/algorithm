package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIV {

    private int res;

    /**
     * @param nums: a list of integers
     * @return return an integer
     */
    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        help(nums[0] / 10, map, 0);
        return res;
    }

    private void help(int num, Map<Integer, Integer> map, int curr) {
        curr += map.get(num);
        int left = (num / 10 + 1) * 10 + 2 * (num % 10) - 1;
        int right = left + 1;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            res += curr;
            return;
        }
        if (map.containsKey(left)) {
            help(left, map, curr);
        }
        if (map.containsKey(right)) {
            help(right, map, curr);
        }
    }
}
