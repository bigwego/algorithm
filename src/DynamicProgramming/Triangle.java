class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i > -1; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
        }
        return dp[0];
    }
}
