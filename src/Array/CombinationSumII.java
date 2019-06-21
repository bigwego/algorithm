package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        help(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList arrayList, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(arrayList));
        }
        for (int i = start; i < candidates.length; i++) {
            if ((i > start && candidates[i] == candidates[i - 1]) || candidates[i] > target) {
                continue;
            }
            arrayList.add(candidates[i]);
            help(res, arrayList, candidates, target - candidates[i], i + 1);
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        help2(res, new ArrayList<Integer>(), candidates, 0, 0, target);

        return res;
    }

    private void help2(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int idx, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || idx == nums.length) return;

        for (int i = idx, len = nums.length; i < len && nums[i] <= sum - target; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            help2(res, list, nums, i + 1, sum + nums[i], target);
            list.remove(list.size() - 1);
        }
    }
}
