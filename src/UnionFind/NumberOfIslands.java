package UnionFind;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    mark(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    private void mark(char[][] grid, int i, int j, int m, int n) {
        if (i == -1 || j == -1 || i == m || j == n || grid[i][j] != '0') {
            return;
        }
        grid[i][j] = '#';
        mark(grid, i + 1, j, m, n);
        mark(grid, i - 1, j, m, n);
        mark(grid, i, j + 1, m, n);
        mark(grid, i, j - 1, m, n);
    }
}
