package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new LinkedList<>(), 0, nums);
        return res;
    }

    private void help(List<List<Integer>> res, LinkedList<Integer> list, int idx, int[] nums) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (list.size() == 0 || nums[i] >= list.peekLast()) {
                set.add(nums[i]);
                list.add(nums[i]);
                help(res, list, i + 1, nums);
                list.pollLast();
            }
        }
    }
}
