package Array;

public class RLEIterator {

    int[] A;

    private int idx;

    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        int len = A.length;
        while (idx < len && n > A[idx]) {
            n -= A[idx];
            idx += 2;
        }
        if (idx < len) {
            A[idx] -= n;
            return A[idx + 1];
        }
        return -1;
    }
}
