package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    private Map<String, List<String>> map = new HashMap<>();

    private List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.length() == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String pre = s.substring(0, i);
            if (wordDict.contains(pre)) {
                List<String> list = wordBreak(s.substring(i), wordDict);
                if (list == null) {
                    res.add(pre);
                } else {
                    for (String str : list) {
                        res.add(pre + " " + str);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
