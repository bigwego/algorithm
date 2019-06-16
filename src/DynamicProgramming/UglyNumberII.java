package DynamicProgramming;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[idx2] * 2, Math.min(res[idx3] * 3, res[idx5] * 5));
            if (res[i] == res[idx2] * 2) {
                idx2++;
            }
            if (res[i] == res[idx3] * 3) {
                idx3++;
            }
            if (res[i] == res[idx5] * 5) {
                idx5++;
            }
        }
        return res[n - 1];
    }

    public int nthUglyNumber2(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;

        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[idx2] * 2, Math.min(res[idx3] * 3, res[idx5] * 5));
            if (res[i] == res[idx2] * 2) idx2++;
            if (res[i] == res[idx3] * 3) idx3++;
            if (res[i] == res[idx5] * 5) idx5++;
        }

        return res[n - 1];
    }
}
