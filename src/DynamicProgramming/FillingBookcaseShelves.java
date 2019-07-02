package DynamicProgramming;

public class FillingBookcaseShelves {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int len = books.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;

        for (int i = 1; i <= len; i++) {
            int w = books[i - 1][0];
            int h = books[i - 1][1];
            dp[i] = h + dp[i - 1];
            for (int j = i - 1; j > 0 && w + books[j - 1][0] <= shelf_width; j--) {
                w += books[j - 1][0];
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], h + dp[j - 1]);
            }
        }

        return dp[len];
    }
}
