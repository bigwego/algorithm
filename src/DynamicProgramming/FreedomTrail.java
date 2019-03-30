package DynamicProgramming;

public class FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        int[][] dp = new int[m + 1][n];
        for (int i = m - 1; i > -1; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (key.charAt(i) == ring.charAt(k)) {
                        int diff = Math.abs(j - k);
                        diff = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], diff + dp[i + 1][k]);
                    }
                }
            }
        }
        return dp[0][0] + m;
    }
}
