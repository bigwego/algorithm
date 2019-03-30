package BFS;

import java.util.LinkedList;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{ i, j });
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];
                if (ni == -1 || nj == -1 || ni == m || nj == n
                        || matrix[ni][nj] <= matrix[curr[0]][curr[1]] + 1) {
                    continue;
                }
                matrix[ni][nj] = matrix[curr[0]][curr[1]] + 1;
                queue.add(new int[]{ ni, nj });
            }
        }
        return matrix;
    }
}
