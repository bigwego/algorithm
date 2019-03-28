class ReverseStringII {
    public String reverseStr(String s, int k) {
        if (k < 2) return s;
        int idx = 0;
        char[] chs = s.toCharArray();
        while (idx < s.length()) {
            reverse(chs, idx, Math.min(idx + k - 1, s.length() - 1));
            idx += 2 * k;
        }
        return String.valueOf(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = tmp;
        }
    }
}
