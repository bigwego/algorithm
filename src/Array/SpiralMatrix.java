package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        int m = matrix.length, n = matrix[0].length;
        help(res, 0, 0, m - 1, n - 1, matrix);

        return res;
    }

    private void help(List<Integer> res, int ti, int tj, int bi, int bj, int[][] matrix) {
        if (ti > bi || tj > bj) return;

        for (int j = tj; j <= bj; j++) {
            res.add(matrix[ti][j]);
        }
        for (int i = ti + 1; i <= bi; i++) {
            res.add(matrix[i][bj]);
        }
        if (ti != bi) {
            for (int j = bj - 1; j >= tj; j--) {
                res.add(matrix[bi][j]);
            }
        }
        if (tj != bj) {
            for (int i = bi - 1; i > ti; i--) {
                res.add(matrix[i][tj]);
            }
        }
        help(res, ti + 1, tj + 1, bi - 1, bj - 1, matrix);
    }
}
