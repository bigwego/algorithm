package DynamicProgramming;

import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i > -1; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n - 2; i > -1; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0, len = row.size(); j < len; j++) {
                row.set(j, Math.min(next.get(j), next.get(j + 1)) + row.get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i > -1; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0, len = row.size(); j < len; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + row.get(j);
            }
        }

        return dp[0];
    }
}
