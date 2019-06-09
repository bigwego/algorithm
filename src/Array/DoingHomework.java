package Array;

import java.util.Map;
import java.util.TreeMap;

public class DoingHomework {

    public long doingHomework(int[] cost, int[] val) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        long sum = 0;

        for (int i = 0, len = cost.length; i < len; i++) {
            sum += cost[i];
            map.put(sum, i + 1);
        }

        long res = 0;

        for (int v : val) {
            Integer key = map.get((long) v);
            if (key != null) {
                res += v;
            } else {
                Map.Entry<Long, Integer> floor = map.floorEntry((long) v);
                res += floor == null ? 0 : floor.getKey();
            }
        }

        return res;
    }
}
