package Array;

public class MaximumSumOf2NonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length;
        int[] pre = new int[len];
        pre[0] = A[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] + A[i];
        }

        int res = pre[L + M - 1];
        int maxL = pre[L - 1];
        int maxM = pre[M - 1];

        for (int i = L + M; i < len; i++) {
            maxL = Math.max(maxL, pre[i - M] - pre[i - M - L]);
            maxM = Math.max(maxM, pre[i - L] - pre[i - M - L]);
            res = Math.max(res, Math.max(maxL + pre[i] - pre[i - M], maxM + pre[i] - pre[i - L]));
        }

        return res;
    }

}
