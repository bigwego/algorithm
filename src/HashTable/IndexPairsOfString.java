package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IndexPairsOfString {

    public int[][] indexPairs(String text, String[] words) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String w : words) {
            char c = w.charAt(0);
            map.putIfAbsent(c, new TreeSet<>((s1, s2) -> s1.length() - s2.length()));
            map.get(c).add(w);
        }

        List<int[]> list = new ArrayList<>();

        for (int i = 0, len = text.length(); i < len; i++) {
            char c = text.charAt(i);
            if (!map.containsKey(c)) {
                continue;
            }
            for (String w : map.get(c)) {
                if (text.substring(i, i + w.length()).equals(w)) {
                    list.add(new int[]{ i, i + w.length() - 1 });
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
