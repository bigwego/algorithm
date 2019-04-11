package Array;

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int x = A.length;
        int y = A[0].length;
        int z = B[0].length;
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < z; k++) {
                        if (B[j][k] != 0) {
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return res;
    }
}
