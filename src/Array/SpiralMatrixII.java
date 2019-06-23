package Array;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int ti = 0, tj = 0;
        int bi = n - 1, bj = n - 1;
        int num = 1;

        while (ti <= bi && tj <= bj) {
            for (int i = tj; i <= bj; i++)
                res[ti][i] = num++;

            for (int i = ti + 1; i <= bi; i++)
                res[i][bj] = num++;

            if (ti < bi) {
                for (int i = bj - 1; i >= tj; i--)
                    res[bi][i] = num++;
            }

            if (tj < bj) {
                for (int i = bi - 1; i > ti; i--)
                    res[i][tj] = num++;
            }

            ti++;
            tj++;
            bi--;
            bj--;
        }

        return res;
    }
}
