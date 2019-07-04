package Others;

public class ReverseInteger {

    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) return 0;
            res = tmp;
            x /= 10;
        }

        return res;
    }

    public int reverse2(int x) {
        int res = 0, tmp = 0;

        while (x != 0) {
            tmp = 10 * res + x % 10;
            if (tmp / 10 != res) return 0;
            res = tmp;
            x /= 10;
        }

        return res;
    }
}
