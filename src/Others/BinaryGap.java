package Others;

public class BinaryGap {

    public int binaryGap(int N) {
        int prev = -1;
        int res = 0;

        for (int i = 0; i < 32 && N != 0; i++) {
            if ((N & 1) == 1) {
                if (prev != -1) {
                    res = Math.max(res, i - prev);
                }
                prev = i;
            }
            N >>>= 1;
        }

        return res;
    }
}
