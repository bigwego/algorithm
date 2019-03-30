package HashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        char[] chp = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (chp.length != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < chp.length; i++) {
            char c = chp[i];
            String s = strs[i];
            if (map.containsKey(c)) {
                if (!s.equals(map.get(c))) {
                    return false;
                }
            } else {
                if (map.containsValue(s)) {
                    return false;
                }
                map.put(c, s);
            }
        }
        return true;
    }
}
