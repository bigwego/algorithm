package Others;

public class TrailingZeros {

    public long trailingZeros(long n) {
        int res = 0;
        while (n % 5 == 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}