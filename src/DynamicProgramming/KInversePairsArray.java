package DynamicProgramming;

public class KInversePairsArray {

    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if (k < 0 || k > n * (n - 1) / 2) {
            return 0;
        }
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                for (int m = 0; m <= k; m++) {
                    if (m - j >= 0 && m - j <= k) {
                        dp[i][m] = (dp[i][m] + dp[i - 1][m - j]) % mod;
                    }
                }
            }
        }
        return (int) dp[n][k];
    }
}
