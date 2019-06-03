package Array;

import java.util.Arrays;

public class FlipColumnsForMaximumNumberOfEqualRows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            int[] flip = flip(matrix[i]);
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (Arrays.equals(matrix[i], matrix[j]) || Arrays.equals(flip, matrix[j])) {
                    cnt++;
                }
            }
            res = Math.max(res, cnt);
        }

        return res;
    }

    private int[] flip(int[] row) {
        int[] res = new int[row.length];
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = 1 - row[i];
        }
        return res;
    }
}
