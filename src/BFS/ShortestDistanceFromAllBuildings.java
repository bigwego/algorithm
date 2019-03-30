package BFS;

import java.util.LinkedList;

public class ShortestDistanceFromAllBuildings {

    /**
     * @param grid: the 2D grid
     * @return the shortest distance
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int b = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    b++;
                }
            }
        }
        int[][] distSum = new int[m][n];
        int[][] hit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!bfs(grid, i, j, m, n, distSum, hit, b)) {
                        return -1;
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hit[i][j] == b) {
                    res = Math.min(res, distSum[i][j]);
                }
            }
        }
        return res;
    }

    private boolean bfs(int[][] grid, int i, int j, int m, int n, int[][] distSum, int[][] hit, int b) {
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ i, j });
        int dist = 0, cntB = 1;
        int[][] dirs = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int k = 0; k < size; k++) {
                int[] p = queue.poll();
                for (int[] dir : dirs) {
                    int ni = p[0] + dir[0];
                    int nj = p[1] + dir[1];
                    if (ni == -1 || nj == -1 || ni == m || nj == n || visited[ni][nj]) {
                        continue;
                    }
                    visited[ni][nj] = true;
                    if (grid[ni][nj] == 1) {
                        cntB++;
                    } else if (grid[ni][nj] == 0) {
                        hit[ni][nj]++;
                        distSum[ni][nj] += dist;
                        queue.add(new int[]{ ni, nj });
                    }
                }
            }
        }
        return cntB == b;
    }
}
