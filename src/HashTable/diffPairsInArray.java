package HashTable;

import java.util.HashMap;
import java.util.Map;

public class diffPairsInArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        if (k == 0) {
            for (int key : map.keySet()) {
                if (map.get(key) > 1) {
                    cnt++;
                }
            }
            return cnt;
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + k)) {
                cnt++;
            }
        }
        return cnt;
    }
}
