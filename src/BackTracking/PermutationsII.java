package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        help(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);

        return res;
    }

    private void help(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0, len = nums.length; i < len; i++) {
            if ((i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) || visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            help(res, nums, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
