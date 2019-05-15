package DFS;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            if (A[i][0] == 1) {
                dfs(i, 0, m, n, A);
            }
            if (A[i][n - 1] == 1) {
                dfs(i, n - 1, m, n, A);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (A[0][i] == 1) {
                dfs(0, i, m, n, A);
            }
            if (A[m - 1][i] == 1) {
                dfs(m - 1, i, m, n, A);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, int m, int n, int[][] a) {
        if (i == -1 || j == -1 || i == m || j == n || a[i][j] != 1) {
            return;
        }
        a[i][j] = -1;
        dfs(i - 1, j, m, n, a);
        dfs(i + 1, j, m, n, a);
        dfs(i, j - 1, m, n, a);
        dfs(i, j + 1, m, n, a);
    }
}
