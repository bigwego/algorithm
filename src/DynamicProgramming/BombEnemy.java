package DynamicProgramming;

public class BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0, rowKill = 0;
        int[] colKill = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowKill = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowKill++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colKill[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colKill[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, rowKill + colKill[j]);
                }
            }
        }
        return res;
    }
}
