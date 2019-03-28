public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        int idx = chs.length - 2;
        while (idx > -1) {
            if (chs[idx] < chs[idx + 1]) break;
            idx--;
        }
        if (idx == -1) return -1;
        int small = idx;
        int big = chs.length - 1;
        while (big > small && chs[big] <= chs[small]) big--;
        swap(chs, small, big);
        reverse(chs, small + 1, chs.length - 1);
        long res = Long.valueOf(new String(chs));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i++, j--);
        }
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
