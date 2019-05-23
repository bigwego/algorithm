package DFS;

public class RegionsCutBySlashes {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            char[] chs = grid[i].toCharArray();
            for (int j = 0, len = chs.length, idx = 0; j < len; ) {
                if (chs[j] == '/') {
                    g[3 * i][3 * idx + 2] = 1;
                    g[3 * i + 1][3 * idx + 1] = 1;
                    g[3 * i + 2][3 * idx] = 1;
                    j++;
                } else if (chs[j] == '\\') {
                    g[3 * i][3 * idx] = 1;
                    g[3 * i + 1][3 * idx + 1] = 1;
                    g[3 * i + 2][3 * idx + 2] = 1;
                    j += 1;
                } else {
                    j++;
                }
                idx++;
            }
        }

        int region = 0;
        for (int i = 0, len = g.length; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dfs(g, i, j, len);
                region++;
            }
        }
        return region;
    }

    private void dfs(int[][] g, int i, int j, int n) {
        if (i == -1 || j == -1 || i == n || j == n || g[i][j] == 1) {
            return;
        }
        g[i][j] = 1;
        dfs(g, i - 1, j, n);
        dfs(g, i + 1, j, n);
        dfs(g, i, j - 1, n);
        dfs(g, i, j + 1, n);
    }
}
