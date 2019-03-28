package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Sum4II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                if (!map.containsKey(a + b)) {
                    map.put(a + b, 1);
                } else {
                    map.put(a + b, map.get(a + b) + 1);
                }
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d)) {
                    res += map.get(-c - d);
                }
            }
        }
        return res;
    }
}
