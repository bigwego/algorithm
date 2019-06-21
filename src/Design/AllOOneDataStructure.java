package Design;

import java.util.HashMap;
import java.util.Map;

public class AllOOneDataStructure {

    Map<String, Integer> map;

    int min = 0;

    int max = 0;

    /**
     * Initialize your data structure here.
     */
    public AllOOneDataStructure() {
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (map.containsKey(key))
            map.put(key, map.get(key) + 1);
        else map.put(key, 1);
        max = Math.max(max, map.get(key));
        min = Math.min(min, map.get(key));
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) return;

    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return "";
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return "";
    }
}
