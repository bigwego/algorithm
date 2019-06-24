package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int res = 0;

        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d))
                    res+=map.get(-c-d);
            }
        }

        return res;
    }
}
