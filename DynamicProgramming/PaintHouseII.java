public class PaintHouseII {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int preMin1 = -1, preMin2 = -1;
        int m = costs.length, k = costs[0].length;
        for (int i = 0; i < m; i++) {
            int nextMin1 = -1, nextMin2 = -1;
            for (int j = 0; j < k; j++) {
                costs[i][j] += preMin1 < 0 ? 0 : (j == preMin1 ? costs[i - 1][preMin2] : costs[i - 1][preMin1]);
                if (nextMin1 == -1 || costs[i][j] < costs[i][nextMin1]) {
                    nextMin2 = nextMin1;
                    nextMin1 = j;
                } else if (nextMin2 == -1 || costs[i][j] < costs[i][nextMin2]) {
                    nextMin2 = j;
                }
            }
            preMin1 = nextMin1;
            preMin2 = nextMin2;
        }
        return costs[m - 1][preMin1];
    }
}
