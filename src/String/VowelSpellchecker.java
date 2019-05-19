package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String low = w.toLowerCase();
            String vow = low.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(low, w);
            vowel.putIfAbsent(vow, w);
        }

        String[] res = new String[queries.length];
        for (int i = 0, len = res.length; i < len; i++) {
            String q = queries[i];
            String low = q.toLowerCase();
            String vow = low.replaceAll("[aeiou]", "#");
            if (set.contains(q)) {
                res[i] = q;
            } else if (cap.containsKey(low)) {
                res[i] = cap.get(low);
            } else if (vowel.containsKey(vow)) {
                res[i] = vowel.get(vow);
            } else {
                res[i] = "";
            }
        }
        return res;
    }

}
