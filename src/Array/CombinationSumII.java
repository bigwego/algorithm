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
}
