package HashTable;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        int res = 0;
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            res += (cnt + key) / (key + 1) * (key + 1);
        }

        return res;
    }
}
