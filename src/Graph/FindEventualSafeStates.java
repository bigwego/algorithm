package Graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, color)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int idx, int[] color) {
        if (color[idx] != 0) {
            return color[idx] == 1;
        }
        color[idx] = 2;
        for (int next : graph[idx]) {
            if (!dfs(graph, next, color)) {
                return false;
            }
        }
        color[idx] = 1;
        return true;
    }
}
