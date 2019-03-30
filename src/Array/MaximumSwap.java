package Array;

public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] chs = ("" + num).toCharArray();
        int len = chs.length;
        int[] buckets = new int[10];
        for (int i = 0; i < len; i++) {
            buckets[chs[i] - '0'] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 9; j > chs[i] - '0'; j--) {
                if (buckets[j] > i) {
                    char tmp = chs[i];
                    chs[i] = chs[buckets[j]];
                    chs[buckets[j]] = tmp;
                    return Integer.valueOf(new String(chs));
                }
            }
        }
        return num;
    }
}
