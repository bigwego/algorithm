package BFS;

import java.util.LinkedList;

public class ShortestBridge {

    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        boolean found = false;
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, m, n, queue, visited);
                    found = true;
                    break;
                }
            }
        }

        int res = 0;
        int[] dirs = new int[]{ 0, 1, 0, -1, 0 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int i = queue.peek()[0];
                int j = queue.poll()[1];

                for (int k = 0; k < 4; k++) {
                    int ni = i + dirs[k];
                    int nj = j + dirs[k + 1];
                    if (A[i][j] == 1) {
                        return res;
                    }
                    if (ni == -1 || nj == -1 || ni == m || nj == n || A[ni][nj] == 2) {
                        continue;
                    }
                    A[ni][nj] = 2;
                    queue.add(new int[]{ ni, nj });
                }
            }
        }

        return -1;

    }

    private void dfs(int[][] a, int i, int j, int m, int n, LinkedList<int[]> queue, boolean[][] visited) {
        if (i == -1 || j == -1 || i == m || j == n || a[i][j] != 1 || visited[i][j]) {
            return;
        }
        a[i][j] = 2;
        visited[i][j] = true;
        queue.add(new int[]{ i, j });
        dfs(a, i - 1, j, m, n, queue, visited);
        dfs(a, i + 1, j, m, n, queue, visited);
        dfs(a, i, j - 1, m, n, queue, visited);
        dfs(a, i, j + 1, m, n, queue, visited);
    }

}
