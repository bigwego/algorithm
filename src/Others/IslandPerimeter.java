class IslandPerimeter {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 4 - getNeighbours(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    private int getNeighbours(int[][] grid, int i, int j, int m, int n) {
        int cnt = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni == -1 || nj == -1 || ni == m || nj == n || grid[ni][nj] == 0) {
                continue;
            }
            cnt++;
        }
        return cnt;
    }
}
