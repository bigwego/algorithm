class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int i = -1, j = 0;
        for (; j < chs.length; j++) {
            if (chs[j] == ' ') {
                reverse(chs, ++i, j - 1);
                i = j;
            }
        }
        reverse(chs, ++i, j - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = tmp;
        }
    }
}
