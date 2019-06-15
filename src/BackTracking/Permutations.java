package BackTracking;

import java.util.ArrayList;
import java.util.List;

// Problem 46. Permutations
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];

        help(res, new ArrayList<Integer>(), nums, used);

        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0, len = nums.length; i < len; i++) {
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            help(res, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
