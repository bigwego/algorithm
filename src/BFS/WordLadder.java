package BFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Problem 127. Word Ladder
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

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> toSee = new HashSet<>();
        toSee.add(beginWord);
        int step = 0;

        while (!toSee.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            for (String curr : toSee) {
                if (curr.equals(endWord)) return step;
                for (int i = 0, len = curr.length(); i < len; i++) {
                    StringBuilder sb = new StringBuilder(curr);
                    for (char newChar = 'a'; newChar <= 'z'; newChar++) {
                        sb.setCharAt(i, newChar);
                        String tmpStr = sb.toString();
                        if (words.contains(tmpStr)) {
                            tmp.add(tmpStr);
                            words.remove(tmpStr);
                        }
                    }
                }
            }
            step++;
            if (tmp.isEmpty()) break;
            toSee = tmp;
        }

        return 0;
    }
}
