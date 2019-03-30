package Array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        help(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
        res.add(new ArrayList<>(list));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            help(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
