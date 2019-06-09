package HashTable;

import java.util.HashMap;
import java.util.Map;

public class SaveMoney {

    public int[] getAns(int[] op, String[] name, int[] w) {
        Map<String, Integer> map = new HashMap<>();
        int len = op.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            if (op[i] == 0) {
                map.put(name[i], map.getOrDefault(name[i], 0) + w[i]);
                res[i] = map.get(name[i]);
            } else if (op[i] == 1) {
                if (!map.containsKey(name[i])) {
                    res[i] = -1;
                } else if (map.get(name[i]) < w[i]) {
                    res[i] = -1;
                } else {
                    map.put(name[i], map.get(name[i]) - w[i]);
                    res[i] = map.get(name[i]);
                }
            }
        }

        return res;
    }
}
