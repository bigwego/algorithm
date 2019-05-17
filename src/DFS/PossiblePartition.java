package DFS;

public class PossiblePartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for (int[] d : dislikes) {
            graph[d[0] - 1][d[1] - 1] = 1;
            graph[d[1] - 1][d[0] - 1] = 1;
        }

        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (group[i] == 0) {
                if (!dfs(graph, group, i, 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] group, int idx, int g) {
        group[idx] = g;
        for (int i = 0, len = graph.length; i < len; i++) {
            if (graph[idx][i] == 1) {
                if (group[i] == g) {
                    return false;
                }
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }
}
