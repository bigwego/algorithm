package String;

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {

    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        init(map);
        char[] chs = s.toCharArray();
        for (char c : chs) {
            res += map.get(c);
        }
        for (int i = 0, len = chs.length; i < len - 1; i++) {
            if (map.get(chs[i]) < map.get(chs[i + 1])) {
                res -= 2 * map.get(chs[i]);
            }
        }
        return res;
    }

    private void init(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
