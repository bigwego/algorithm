package BFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        reached.add(beginWord);
        int step = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chs = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chs[i] = ch;
                        String word = new String(chs);
                        if (dict.contains(word)) {
                            toAdd.add(word);
                            dict.remove(word);
                        }
                    }
                }
            }
            step++;
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return step;
    }
}
