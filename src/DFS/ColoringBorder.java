package DFS;

public class ColoringBorder {

    private final int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        dfs(grid, r0, c0, m, n, grid[r0][c0]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }


    private void dfs(int[][] grid, int r, int c, int m, int n, int clr) {
        grid[r][c] = -clr;
        int cnt = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr == -1 || nc == -1 || nr == m || nc == n || Math.abs(grid[nr][nc]) != clr) {
                continue;
            }
            cnt++;
            if (grid[nr][nc] == clr) {
                dfs(grid, nr, nc, m, n, clr);
            }
        }
        if (cnt == 4) {
            grid[r][c] = clr;
        }
    }
}
