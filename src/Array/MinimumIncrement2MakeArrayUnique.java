package Array;

import java.util.Arrays;

public class MinimumIncrement2MakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        int min = A[0];
        for (int i = 1, len = A.length; i < len; i++) {
            if (A[i] <= min) {
                res += min - A[i] + 1;
            }
            min = Math.max(min + 1, A[i]);
        }

        return res;
    }
}
