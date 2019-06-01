package Array;

public class FixedPoint {

    public int fixedPoint(int[] A) {
        int res = -1;

        for (int i = 0, len = A.length; i < len; i++) {
            if (A[i] < 0) {
                continue;
            }
            if (A[i] == i) {
                res = i;
                break;
            } else if (A[i] - i > 0) {
                break;
            }
        }

        return res;
    }
}
