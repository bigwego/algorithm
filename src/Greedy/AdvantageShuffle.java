package Greedy;

import java.util.TreeMap;

public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            Integer ceil = map.ceilingKey(B[i]);
            if (ceil == null) {
                res[i] = map.firstKey();
            } else {
                res[i] = ceil;
            }
            map.put(res[i], map.get(res[i]) - 1);
            if (map.get(res[i]) == 0) {
                map.remove(res[i]);
            }
        }
        return res;
    }
}
