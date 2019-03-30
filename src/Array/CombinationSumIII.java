package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        help(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList arrayList, int start, int cnt, int target) {
        if (target == 0 && cnt == 0) {
            res.add(new ArrayList<>(arrayList));
            return;
        } else if (target == 0 || cnt == 0) {
            return;
        }
        for (int i = start; i <= 10 - cnt; i++) {
            arrayList.add(i);
            help(res, arrayList, i + 1, cnt - 1, target - i);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
