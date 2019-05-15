package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int m = s.length();
        int n = words.length;

        Map<String, Integer> cnts = new HashMap<>();
        for (String word : words) {
            cnts.put(word, cnts.getOrDefault(word, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0, max = m - n * len; i < max; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < n) {
                String curr = s.substring(i + j * len, i + (j + 1) * len);
                if (!cnts.containsKey(curr)) {
                    break;
                }
                seen.put(curr, seen.getOrDefault(curr, 0) + 1);
                if (cnts.get(curr) < seen.get(curr)) {
                    break;
                }
            }
            if (j == n) {
                res.add(i);
            }
        }

        return res;
    }
}
