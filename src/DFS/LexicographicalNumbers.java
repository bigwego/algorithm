package DFS;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>(n);
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int i, int n, List<Integer> res) {
        if (i > n) {
            return;
        }
        res.add(i);
        for (int j = 0; j < 10; j++) {
            int next = i * 10 + j;
            if (next > n) {
                return;
            }
            dfs(next, n, res);
        }
    }
}
