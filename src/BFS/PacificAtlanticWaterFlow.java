package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    private List<int[]> res = new ArrayList<>();

    private int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        LinkedList<int[]> pQueue = new LinkedList<>();
        LinkedList<int[]> aQueue = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pQueue.add(new int[]{ i, 0 });
            pVisited[i][0] = true;
            aQueue.add(new int[]{ i, n - 1 });
            aVisited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pQueue.add(new int[]{ 0, i });
            pVisited[0][i] = true;
            aQueue.add(new int[]{ m - 1, i });
            aVisited[m - 1][i] = true;
        }

        bfs(pQueue, matrix, m, n, pVisited);
        bfs(aQueue, matrix, m, n, aVisited);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    res.add(new int[]{ i, j });
                }
            }
        }
        return res;
    }

    private void bfs(LinkedList<int[]> queue, int[][] matrix, int m, int n, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];
                if (nx == -1 || ny == -1 || nx == m || ny == n || visited[nx][ny]
                        || matrix[nx][ny] < matrix[curr[0]][curr[1]]) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{ nx, ny });
            }
        }
    }
}
