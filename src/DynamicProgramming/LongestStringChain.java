package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        Map<String, Integer> dp = new HashMap<>();
        int res = 0;

        for (String w : words) {
            if (w.length() == 1) {
                dp.put(w, 1);
            } else {
                int currMax = 1;
                for (int i = 0; i < w.length(); i++) {
                    String prev = w.substring(0, i) + w.substring(i + 1);
                    currMax = Math.max(currMax, dp.getOrDefault(prev, 0) + 1);
                }
                dp.put(w, currMax);
                res = Math.max(res, currMax);
            }
        }

        return res;
    }
}
