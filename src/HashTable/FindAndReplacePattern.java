package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        Map<Character, Character> map;
        int len = pattern.length();

        for (String w : words) {
            if (w.length() != len) {
                continue;
            }
            map = new HashMap<>();
            int i = 0;
            for (; i < len; i++) {
                char wc = w.charAt(i);
                char pc = pattern.charAt(i);
                if (map.containsKey(pc) && map.get(pc) != wc) {
                    break;
                }
                if (!map.containsKey(pc)) {
                    if (map.values().contains(wc)) {
                        break;
                    }
                    map.put(pc, wc);
                }
            }
            if (i == len) {
                res.add(w);
            }
        }
        return res;
    }
}
