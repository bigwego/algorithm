package DynamicProgramming;

public class KnightDialer {

    private static final int mod = 1000000007;

    public int knightDialer(int N) {
        int[][][] dp = new int[4][3][N];
        int res = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                res = (res + getPaths(dp, i, j, N)) % mod;
            }
        }

        return res;
    }

    private int getPaths(int[][][] dp, int i, int j, int N) {
        if (i < 0 || j < 0 || i > 3 || j > 2 || (i == 3 && j != 1)) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (dp[i][j][N] != 0) {
            return dp[i][j][N];
        }
        return getPaths(dp, i + 2, j + 1, N - 1) % mod
                + getPaths(dp, i - 2, j + 1, N - 1) % mod
                + getPaths(dp, i + 2, j - 1, N - 1) % mod
                + getPaths(dp, i - 2, j - 1, N - 1) % mod
                + getPaths(dp, i + 1, j + 2, N - 1) % mod
                + getPaths(dp, i + 1, j - 1, N - 1) % mod
                + getPaths(dp, i - 1, j + 2, N - 1) % mod
                + getPaths(dp, i - 1, j - 2, N - 1) % mod;
    }
}
