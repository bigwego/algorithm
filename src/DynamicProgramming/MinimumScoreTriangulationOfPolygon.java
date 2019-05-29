package DynamicProgramming;

public class MinimumScoreTriangulationOfPolygon {

    public int minScoreTriangulation(int[] A) {
        int len = A.length;
        int[][] dp = new int[len][len];

        for (int i = len - 1; i > -1; i--) {
            for (int j = i + 2; j < len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + A[i] * A[j] * A[k] + dp[k][j]);
                }
            }
        }

        return dp[0][len - 1];
    }
}
