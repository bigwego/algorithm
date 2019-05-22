package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

    Map<Integer, Integer> map;

    private int[] times;

    public OnlineElection(int[] persons, int[] times) {
        this.times = times;
        int maxCnt = -1;
        int len = persons.length;
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int p = persons[i];
            int t = times[i];
            cnts.put(p, cnts.getOrDefault(p, 0) + 1);
            if (cnts.get(p) >= maxCnt) {
                maxCnt = p;
                map.put(t, p);
            } else {
                map.put(t, map.get(maxCnt));
            }
        }
    }

    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);
        return idx < 0 ? map.get(times[times.length - 1]) : map.get(times[idx]);
    }
}
