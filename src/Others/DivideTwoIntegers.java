package Others;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int sign = dividend < 0 == divisor < 0 ? 1 : -1;
        if (b == 1) return sign == 1 ? (int) a : (int) -a;

        int res = 0;

        while (a >= b) {
            long t = b, cnt = 1;
            while (a >= (t << 1)) {
                t <<= 1;
                cnt <<= 1;
            }
            a -= t;
            res += cnt;
        }

        return res * sign;
    }
}
