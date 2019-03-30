package DynamicProgramming;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[i] = 1;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            int left = 0;
            for (int j = 0; j < dp.length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    left = 0;
                } else {
                    dp[j] += left;
                    left = dp[j];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
