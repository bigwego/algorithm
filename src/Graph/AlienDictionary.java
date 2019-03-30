package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class AlienDictionary {

    /**
     * @param words: a list of words
     * @return a string which is correct order
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, HashSet<Character>> neighbors = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!neighbors.containsKey(c)) {
                    neighbors.put(c, new HashSet<>());
                }
                if (!indegrees.containsKey(c)) {
                    indegrees.put(c, 0);
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            int j = i + 1;
            int len = Math.min(words[i].length(), words[j].length());
            int k = 0;
            while (k < len) {
                if (words[i].charAt(k) != words[j].charAt(k)) {
                    neighbors.get(words[i].charAt(k)).add(words[j].charAt(k));
                    break;
                }
                k++;
            }
        }
        for (Character key : neighbors.keySet()) {
            for (Character ch : neighbors.get(key)) {
                indegrees.put(ch, indegrees.get(ch) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> queue = new PriorityQueue<>();
        for (Character key : indegrees.keySet()) {
            if (indegrees.get(key) == 0) {
                queue.add(key);
                //indegrees.remove(key);
            }
        }
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            HashSet<Character> nexts = neighbors.get(ch);
            for (Character next : nexts) {
                int cnt = indegrees.get(next) - 1;
                if (cnt == 0) {
                    //indegrees.remove(next);
                    queue.add(next);
                } else {
                    indegrees.put(next, cnt);
                }
            }
        }
        return sb.length() == neighbors.keySet().size() ? sb.toString() : "";
    }
}
