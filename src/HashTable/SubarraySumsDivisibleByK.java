package HashTable;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] A, int K) {
        if (A == null || A.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;

        for (int num : A) {
            sum = (sum + num) % K;
            if (sum < 0) sum += K;
            if (map.containsKey(sum)) res += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}