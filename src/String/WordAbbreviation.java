package String;

import java.util.HashMap;
import java.util.Map;

public class WordAbbreviation {
    /**
     * @param dict: an array of n distinct non-empty strings
     * @return an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        int len = dict.length;
        String[] res = new String[len];
        Map<String, Integer> map = new HashMap<>();
        int[] pre = new int[len];
        for (int i = 0; i < len; i++) {
            pre[i] = 1;
            res[i] = getAbbr(pre[i], dict[i]);
            map.put(res[i], map.getOrDefault(res[i], 0) + 1);
        }
        while (true) {
            boolean unique = true;
            for (int i = 0; i < len; i++) {
                if (map.get(res[i]) > 1) {
                    pre[i]++;
                    unique = false;
                    res[i] = getAbbr(pre[i], dict[i]);
                    map.put(res[i], map.getOrDefault(res[i], 0) + 1);
                }
            }
            if (unique) {
                break;
            }
        }
        return res;
    }

    private String getAbbr(int pre, String s) {
        if (s.length() - pre < 3) {
            return s;
        }
        return s.substring(0, pre) + (s.length() - pre - 1) + s.charAt(s.length() - 1);
    }
}
