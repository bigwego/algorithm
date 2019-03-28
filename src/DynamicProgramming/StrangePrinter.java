class StrangePrinter {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n - 1)
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 2;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = j - i + 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                if (s.charAt(i) == s.charAt(j)) dp[i][j]--;
            }
        }
        return dp[0][n - 1];
    }
}
