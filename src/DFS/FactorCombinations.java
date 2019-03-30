package DFS;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    /**
     * @param n: a integer
     * @return return a 2D array
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, new ArrayList<>(), 2, n);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int start, int n) {
        if (n == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                help(res, list, i, n / i);
                list.remove(list.size() - 1);
            }
        }
    }
}
