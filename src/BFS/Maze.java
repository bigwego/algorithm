package BFS;

import java.util.LinkedList;

public class Maze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            visited[curr[0]][curr[1]] = true;
            for (int[] dir : dirs) {
                int dirx = dir[0];
                int diry = dir[1];
                int x = curr[0], y = curr[1];
                while (isValid(x + dirx, y + diry, maze, m, n)) {
                    x += dirx;
                    y += diry;
                }
                if (x == destination[0] && y == destination[1]) {
                    return true;
                }
                if (!visited[x][y]) {
                    queue.add(new int[]{ x, y });
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int[][] maze, int m, int n) {
        return i > -1 && j > -1 && i < m && j < n && maze[i][j] == 0;
    }
}
