public class WallsAndGates {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j, m, n, 0);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j, int m, int n, int dist) {
        if (i == -1 || j == -1 || i == m || j == n || rooms[i][j] == -1) {
            return;
        }
        if (rooms[i][j] > dist || dist == 0) {
            rooms[i][j] = dist;
            bfs(rooms, i + 1, j, m, n, dist + 1);
            bfs(rooms, i - 1, j, m, n, dist + 1);
            bfs(rooms, i, j + 1, m, n, dist + 1);
            bfs(rooms, i, j - 1, m, n, dist + 1);
        }
    }
}
