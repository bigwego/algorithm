package DynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (e1, e2) -> e1[0] - e2[0]);

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] == e2[0]) return e2[1] - e1[1];
            return e1[0] - e2[0];
        });

        int len = envelopes.length;
        int[] tails = new int[len];
        int size = 0;

        for (int[] e : envelopes) {
            int l = 0, r = size;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (tails[mid] < e[1]) mid = l + 1;
                else r = mid;
            }
            tails[l] = e[1];
            if (l == size) size++;
        }

        return size;
    }

}
