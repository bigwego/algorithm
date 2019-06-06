package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MedianIndex {

    public int getAns(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = a.length; i < len; i++) {
            map.put(a[i], i);
        }

        Arrays.sort(a);
        int len = a.length;
        return map.get(a[(len & 1) == 0 ? len / 2 - 1 : len / 2]);
    }
}