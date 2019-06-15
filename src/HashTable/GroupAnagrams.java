package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private static final int[] PRIMES = new int[]{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107 };

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();

        Map<Integer, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray())
                key *= PRIMES[c - 'a'];
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}
