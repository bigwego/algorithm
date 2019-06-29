package Array;

public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] A, int K) {
        int res = -1;
        int len = A.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = A[i] + A[j];
                if (sum < K) res = Math.max(res, sum);
            }
        }

        return res;
    }
}
