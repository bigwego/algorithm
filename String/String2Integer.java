class String2Integer {
    public int myAtoi(String str) {
        int i = 0, len = str.length(), sign = 1, total = 0;
        char[] chs = str.toCharArray();
        while (i < len && chs[i] == ' ') i++;
        if (i == len) return 0;
        if (chs[i] == '+' || chs[i] == '-')
            sign = chs[i++] == '+' ? 1 : -1;
        while (i < len) {
            int digit = chs[i] - '0';
            if (!Character.isDigit(chs[i])) break;
            if (Integer.MAX_VALUE / 10 < total 
                || (Integer.MAX_VALUE / 10 == total && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = 10 * total + digit;
            i++;
        }
        return sign * total;
    }
}
