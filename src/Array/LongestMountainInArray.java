package Array;

public class LongestMountainInArray {

    public int longestMountain(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }

        int[] up = new int[len];
        int[] down = new int[len];
        int res = 0;

        for (int i = 1; i < len; i++) {
            if (A[i - 1] < A[i]) {
                up[i] = up[i - 1] + 1;
            }
        }
        for (int i = len - 2; i > -1; i--) {
            if (A[i] > A[i + 1]) {
                down[i] = down[i + 1] + 1;
                if (up[i] > 0) {
                    res = Math.max(res, up[i] + down[i] + 1);
                }
            }
        }

        return res;
    }
}
