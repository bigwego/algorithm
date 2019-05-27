package Array;

public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int prevBestIdx = 0;
        for (int i = 1, len = A.length; i < len; i++) {
            res = Math.max(res, A[i] + A[prevBestIdx] + prevBestIdx - i);
            if (A[prevBestIdx] + prevBestIdx < A[i] + i) {
                prevBestIdx = i;
            }
        }
        return res;
    }
}
