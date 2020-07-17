package Graph;

import java.util.Arrays;

public class IsBipartite {

    private static int UNCOLORED = 0;
    private static int RED = 1;
    private static int GREEN = 2;
    private int[] colors;
    private boolean result;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new int[n];
        result = true;

        for (int i = 0; i < n; i++) {
            if (colors[i] == UNCOLORED) {
                dfs(i, RED, graph);
            }
        }

        return result;
    }

    private void dfs(int curr, int color, int[][] graph) {
        colors[curr] = color;
        int[] ns = graph[curr];
        int neighColor = color == RED ? GREEN : RED;

        for (int n : ns) {
            if (colors[n] == UNCOLORED) {
                dfs(n, neighColor, graph);
                if (!result) {
                    return;
                }
            } else if(colors[n] != neighColor) {
                result = false;
                return;
            }
        }
    }
}
