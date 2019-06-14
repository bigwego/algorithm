package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Problem 139. Word Break
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        return help(s, set);
    }

    private boolean help(String s, Set<String> set) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() == 0) return true;

        boolean res = false;

        for (int i = 1, len = s.length(); i <= len; i++) {
            String sub = s.substring(0, i);
            if (set.contains(sub) && help(s.substring(i), set)) {
                res = true;
                break;
            }
        }

        map.put(s, res);
        return res;
    }
}
