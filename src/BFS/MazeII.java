package BFS;

import java.util.LinkedList;

public class MazeII {

    private final int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private final int res = Integer.MAX_VALUE;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ start[0], start[1], 0 });
        visited[start[0]][start[1]] = true;
        int res = Integer.MAX_VALUE;
        boolean found = false;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            int currStep = curr[2];
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                res = Math.min(res, curr[2]);
                found = true;
            }
            if (found) {
                break;
            }
            for (int[] dir : dirs) {
                int tmpStep = currStep;
                int ii = i, jj = j;
                while (isValid(ii + dir[0], jj + dir[1], m, n, maze)) {
                    ii += dir[0];
                    jj += dir[1];
                    tmpStep++;
                }
                if (visited[ii][jj]) {
                    continue;
                } else {
                    visited[ii][jj] = true;
                    queue.add(new int[]{ ii, jj, tmpStep });
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private boolean isValid(int i, int j, int m, int n, int[][] maze) {
        return i != -1 && j != -1 && i != m && j != n && maze[i][j] != 1;
    }
}
