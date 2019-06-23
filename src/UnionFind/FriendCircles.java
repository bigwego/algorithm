package UnionFind;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int n = M.length, res = 0;
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res++;
                dfs(M, visited, i);
            }
        }

        return res;
    }

    private void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int n = M.length, cnt = n;
        int[] u = new int[n];

        for (int i = 0; i < n; i++) u[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int ri = find(u, i);
                    int rj = find(u, j);
                    if (ri != rj) {
                        u[rj] = ri;
                        cnt--;
                    }
                }
            }
        }

        return cnt;
    }

    private int find(int[] u, int i) {
        while (i != u[i]) i = u[u[i]];
        return i;
    }

    public int findCircleNum3(int[][] M) {
        int n = M.length;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) roots[i] = i;

        int cnt = n;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int ri = find3(roots, i);
                    int rj = find3(roots, j);
                    if (ri != rj) {
                        roots[rj] = ri;
                        cnt--;
                    }
                }
            }
        }

        return cnt;
    }

    private int find3(int[] roots, int i) {
        while (roots[i] != i) {
            i = roots[roots[i]];
        }
        return i;
    }
}
