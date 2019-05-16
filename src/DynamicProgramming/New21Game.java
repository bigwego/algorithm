package DynamicProgramming;

public class New21Game {

    public double new21Game(int N, int k, int W) {
        if (k == 0 || N >= k + W) {
            return 1;
        }
        double[] dp = new double[N + 1];
        dp[0] = 1;
        double res = 0;
        double sumW = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = sumW / W;
            if (i < k) {
                sumW += dp[i];
            } else {
                res += dp[i];
            }
            if (i >= W) {
                sumW -= dp[i - W];
            }
        }
        return res;
    }
}
