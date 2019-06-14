package String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// problem 17. Letter Combinations of a Phone Number
public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;

        String[] keys = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        LinkedList<String> queue = new LinkedList<>();
        queue.add("");

        for (char c : digits.toCharArray()) {
            String key = keys[c - '0'];
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (char ch : key.toCharArray()) {
                    queue.add(curr + ch);
                }
            }
        }

        return res;
    }
}
