package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {

    Map<String, List<int[]>> map;

    /**
     * Initialize your data structure here.
     */
    public ImplementMagicDictionary() {
        map = new HashMap<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            for (int i = 0, len = word.length(); i < len; i++) {
                String tmp = word.substring(0, i) + word.substring(i + 1);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new ArrayList<>());
                }
                map.get(tmp).add(new int[]{ i, word.charAt(i) });
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (int i = 0, len = word.length(); i < len; i++) {
            String tmp = word.substring(0, i) + word.substring(i + 1);
            if (!map.containsKey(tmp)) {
                continue;
            }
            List<int[]> list = map.get(tmp);
            for (int[] arr : list) {
                if (arr[0] == i && arr[1] != word.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
