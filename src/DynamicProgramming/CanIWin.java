package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {

    private boolean[] used;

    private Map<Integer, Boolean> map;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 1) {
            return true;
        }
        used = new boolean[maxChoosableInteger + 1];
        map = new HashMap<>();
        return help(desiredTotal);
    }

    private boolean help(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = getKey(used);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 1, len = used.length; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!help(desiredTotal - i)) {
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        map.put(key, false);
        return false;
    }

    private int getKey(boolean[] used) {
        int res = 0;
        for (int i = 1, len = used.length; i < len; i++) {
            if (used[i]) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
