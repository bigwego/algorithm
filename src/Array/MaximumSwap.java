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

    public int maximumSwap2(int num) {
        char[] chs = String.valueOf(num).toCharArray();
        int[] pos = new int[10];
        int len = chs.length;

        for (int i = 0; i < len; i++)
            pos[chs[i] - '0'] = i;

        for (int i = 0; i < len; i++) {
            for (int j = 9; j > chs[i] - '0'; j--) {
                if (pos[j] > i) {
                    char tmp = chs[i];
                    chs[i] = chs[pos[j]];
                    chs[pos[j]] = tmp;
                    return Integer.valueOf(String.valueOf(chs));
                }
            }
        }

        return num;
    }
}
