package DFS;

public class MaxAreaOfIsland {

    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return res;

        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, m, n, new int[]{ 0 });
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int[] cnt) {
        if (i == -1 || j == -1 || i == m || j == n || grid[i][j] != 1) return;
        grid[i][j] = -1;
        cnt[0]++;
        res = Math.max(res, cnt[0]);
        dfs(grid, i - 1, j, m, n, cnt);
        dfs(grid, i + 1, j, m, n, cnt);
        dfs(grid, i, j - 1, m, n, cnt);
        dfs(grid, i, j + 1, m, n, cnt);
    }

    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(max, dfs2(grid, i, j, m, n));
            }
        }

        return max;
    }

    private int dfs2(int[][] grid, int i, int j, int m, int n) {
        if (i == -1 || j == -1 || i == m || j == n || grid[i][j] != 1) return 0;

        grid[i][j] = -1;
        int cnt = 1;
        cnt += dfs2(grid, i + 1, j, m, n) + dfs2(grid, i - 1, j, m, n)
                + dfs2(grid, i, j + 1, m, n) + dfs2(grid, i, j - 1, m, n);

        return cnt;
    }
}
