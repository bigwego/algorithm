package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
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

    public List<String> wordBreak2(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);

        if (s.length() == 0) return null;

        List<String> res = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            String curr = s.substring(0, i);
            if (wordDict.contains(curr)) {
                List<String> next = wordBreak2(s.substring(i), wordDict);
                if (next == null) {
                    res.add(curr);
                } else {
                    for (String n : next)
                        res.add(curr + " " + n);
                }
            }
        }

        map.put(s,res);
        return res;
    }
}
