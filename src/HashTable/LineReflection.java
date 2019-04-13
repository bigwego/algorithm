package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LineReflection {

    public boolean isReflected(int[][] points) {
        if (points.length % 2 != 0) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] p : points) {
            min = Math.min(min, p[0]);
            max = Math.max(max, p[0]);
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }
        double avg = (double) (max + min) / 2;
        for (int[] p : points) {
            int sym = (int) (2 * avg - p[0]);
            if (!map.containsKey(sym) || !map.get(sym).contains(p[1])) {
                return false;
            }
        }
        return true;
    }
}
