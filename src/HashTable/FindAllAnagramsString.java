package HashTable;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int[] hash = new int[26];
        int start = 0, end = 0, cnt = 0;
        for (char c : p.toCharArray()) {
            if (hash[c - 'a']++ == 0) {
                cnt++;
            }
        }
        while (end < s.length()) {
            if (--hash[s.charAt(end) - 'a'] == 0) {
                cnt--;
            }
            end++;
            while (cnt == 0) {
                if (++hash[s.charAt(start) - 'a'] > 0) {
                    cnt++;
                }
                if (end - start == p.length()) {
                    res.add(start);
                }
                start++;
            }
        }
        return res;
    }
}
