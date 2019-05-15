package DynamicProgramming;

import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int res = 0, points = 0;
        while (l < r) {
            if (P >= tokens[l]) {
                res = Math.max(res, ++points);
                P -= tokens[l++];
            } else if (res > 0) {
                points--;
                P += tokens[r--];
            } else {
                break;
            }
        }
        return res;
    }
}