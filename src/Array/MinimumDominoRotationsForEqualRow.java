package Array;

public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] A, int[] B) {
        int[] cntA = new int[7];
        int[] cntB = new int[7];
        int[] same = new int[7];
        for (int i = 0, len = A.length; i < len; i++) {
            cntA[A[i]]++;
            cntB[B[i]]++;
            if (A[i] == B[i]) {
                same[A[i]]++;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (cntA[i] + cntB[i] - same[i] == A.length) {
                return Math.min(cntA[i], cntB[i] - same[i]);
            }
        }
        return -1;
    }
}
