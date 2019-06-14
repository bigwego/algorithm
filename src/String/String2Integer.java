package String;

public class String2Integer {

    public int myAtoi(String str) {
        int i = 0;
        int len = str.length();
        int sign = 1;
        int total = 0;
        char[] chs = str.toCharArray();
        while (i < len && chs[i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        if (chs[i] == '+' || chs[i] == '-') {
            sign = chs[i++] == '+' ? 1 : -1;
        }
        while (i < len) {
            int digit = chs[i] - '0';
            if (!Character.isDigit(chs[i])) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < total
                    || (Integer.MAX_VALUE / 10 == total && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10 * total + digit;
            i++;
        }
        return sign * total;
    }

    public int myAtoi2(String str) {
        char[] chs = str.toCharArray();
        int len = chs.length;
        int sign = 1;
        long total = 0;
        int idx = 0;

        while (idx < len && chs[idx] == ' ') {
            idx++;
        }

        if (idx == len) return 0;
        if (chs[idx] == '+' || chs[idx] == '-')
            sign = chs[idx++] == '+' ? sign : -sign;

        while (idx < len && Character.isDigit(chs[idx])) {
            total = 10 * total + chs[idx] - '0';
            if (total > Integer.MAX_VALUE)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            idx++;
        }

        return sign * (int) total;
    }
}