package Greedy;

import java.util.Arrays;

public class SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int len = A.length;
        int min;
        int max;
        int res = A[len - 1] - A[0];

        for (int i = 0; i < len - 1; i++) {
            max = Math.max(A[i] + K, A[len - 1] - K);
            min = Math.min(A[i + 1] + K, A[0] + K);
            res = Math.min(res, max - min);
        }

        return res;
    }
}
