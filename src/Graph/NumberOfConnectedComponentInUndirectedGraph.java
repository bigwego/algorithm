package Graph;

import java.util.List;

public class NumberOfConnectedComponentInUndirectedGraph {

    public int countComponents(int n, List<int[]> edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        int res = n;
        for (int[] edge : edges) {
            int root1 = find(edge[0], roots);
            int root2 = find(edge[1], roots);
            if (root1 != root2) {
                res--;
                roots[root2] = root1;
            }
        }
        return res;
    }

    private int find(int i, int[] roots) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
