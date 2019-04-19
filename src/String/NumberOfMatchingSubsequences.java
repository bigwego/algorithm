package String;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (String word : words) {
            map.putIfAbsent(word.charAt(0), new LinkedList<>());
            map.get(word.charAt(0)).addLast(word);
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            if (queue == null) {
                continue;
            }
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                String s = queue.pollFirst();
                if (s.length() == 1) {
                    res++;
                } else {
                    map.putIfAbsent(s.charAt(1), new LinkedList<>());
                    map.get(s.charAt(1)).addLast(s.substring(1));
                }
            }
        }
        return res;
    }
}
