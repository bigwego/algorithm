class FriendCircles {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int cnt = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m[0].length; j++) {
            if (visited[j] == 0 && m[i][j] == 1) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }
}
