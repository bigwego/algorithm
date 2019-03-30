package BackTracking;

import java.util.ArrayList;
import java.util.List;

class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int start, int k, int n) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n && i <= 10 - k; i++) {
            list.add(i);
            help(res, list, i + 1, k - 1, n - i);
            list.remove(list.size() - 1);
        }
    }
}
