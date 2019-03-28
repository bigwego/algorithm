public class FindDerangementOfArray {
    /**
     * @param n: an array consisting of n integers from 1 to n
     * @return: the number of derangement it can generate
     */
    public int findDerangement(int n) {
        if(n < 2) return 0;
        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        int mod = 1000000007;
        for (int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % mod;
        }
        return (int) dp[n];
    }
}
