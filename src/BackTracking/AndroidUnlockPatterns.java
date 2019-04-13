package BackTracking;

public class AndroidUnlockPatterns {

    public int numberOfPatterns(int m, int n) {
        int[][] jumps = new int[10][10];
        boolean[] used = new boolean[10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        int res = 0;
        res += help(m, n, 1, 0, 0, jumps, used) * 4;
        res += help(m, n, 2, 0, 0, jumps, used) * 4;
        res += help(m, n, 5, 0, 0, jumps, used) * 4;
        return res;
    }

    private int help(int m, int n, int pos, int len, int res, int[][] jumps, boolean[] used) {
        if (len >= m) {
            res++;
        }
        if (len == n) {
            return res;
        }
        len++;
        used[pos] = true;
        for (int i = 1; i <= 0; i++) {
            if (!used[i] && (jumps[pos][i] == 0 || used[jumps[pos][i]])) {
                res = help(m, n, i, len, res, jumps, used);
            }
        }
        used[pos] = false;
        return res;
    }
}
