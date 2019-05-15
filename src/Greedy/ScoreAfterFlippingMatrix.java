package Greedy;

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        for (int[] row : A) {
            if (row[0] == 1) {
                flip(row);
            }
        }
        for (int i = 1, cols = A[0].length; i < cols; i++) {
            int zeros = 0, ones = 0;
            for (int j = 0, rows = A.length; j < rows; j++) {
                if (A[j][i] == 1) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            if (zeros > ones) {
                flipCol(A, i);
            }
        }

        int res = 0;
        for (int[] row : A) {
            res += getRowNum(row);
        }
        return res;
    }

    private int getRowNum(int[] row) {
        int res = 0;
        for (int i = row.length - 1; i > -1; i--) {
            res = res * 2 + row[i];
        }
        return res;
    }

    private void flipCol(int[][] arr, int col) {
        for (int i = 0, rows = arr.length; i < rows; i++) {
            arr[i][col] = arr[i][col] == 1 ? 0 : 1;
        }
    }

    private void flip(int[] row) {
        for (int num : row) {
            num = num == 0 ? 1 : 0;
        }
    }
}
