package BFS;

import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int[][] dirs = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { 1, 1 }, { -1, -1 } };
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ 0, 0 });
        int m = grid.length, res = 1;
        boolean[][] visited = new boolean[m][m];

        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                int[] curr = queue.poll();
                visited[curr[0]][curr[1]] = true;
                if (curr[0] == m - 1 && curr[1] == m - 1) return res;
                for (int[] dir : dirs) {
                    int ni = curr[0] + dir[0];
                    int nj = curr[1] + dir[1];
                    if (isValid(ni, nj, grid, m, visited)) {
                        queue.add(new int[]{ ni, nj });
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid, int m, boolean[][] visited) {
        return i != -1 && j != -1 && i != m && j != m && !visited[i][j] && grid[i][j] == 0;
    }
}
