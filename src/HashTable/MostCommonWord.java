package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for (String b : banned) ban.add(b);

        Map<String, Integer> cnts = new HashMap<>();
        String[] words = paragraph.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!ban.contains(word))
                cnts.put(word, cnts.getOrDefault(word, 0) + 1);
        }

        int cnt = 0;
        String res = "";

        for (String word : cnts.keySet()) {
            if (cnts.get(word) > cnt) {
                cnt = cnts.get(word);
                res = word;
            }
        }

        return res;
    }
}
