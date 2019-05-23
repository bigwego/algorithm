package SlidingWindow;

public class MaxconsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int s = 0;
        int res = 0;
        int cnt = 0;

        for (int e = 0, len = A.length; e < len; e++) {
            if (A[e] == 0) {
                cnt++;
            }
            while (cnt > K) {
                if (A[s] == 0) {
                    cnt--;
                }
                s++;
            }
            res = Math.max(res, e - s + 1);
        }

        return res;
    }
}
