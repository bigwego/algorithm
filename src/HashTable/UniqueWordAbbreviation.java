package HashTable;

import java.util.HashMap;
import java.util.Map;

public class UniqueWordAbbreviation {

    private final Map<String, Integer> dict;

    private final Map<String, Integer> abbr;

    /**
     * @param dictionary: a list of words
     */
    public UniqueWordAbbreviation(String[] dictionary) {
        dict = new HashMap<>();
        abbr = new HashMap<>();
        for (String word : dictionary) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
            String abbrev = getAbbr(word);
            abbr.put(abbrev, abbr.getOrDefault(abbrev, 0) + 1);
        }
    }

    private String getAbbr(String word) {
        if (word.length() < 3) {
            return word;
        }
        return word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1, word.length());
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        String abbrev = getAbbr(word);
        return dict.get(word) == abbr.get(abbrev);
    }
}
