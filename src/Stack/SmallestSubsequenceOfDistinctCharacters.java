package Stack;

import java.util.Stack;

public class SmallestSubsequenceOfDistinctCharacters {

    public String smallestSubsequence(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        Stack<Integer> stack = new Stack<>();
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = text.length(); i < len; i++) {
            last[text.charAt(i) - 'a'] = i;
        }

        for (int i = 0, len = text.length(); i < len; i++) {
            int c = text.charAt(i) - 'a';
            if (seen[c]) continue;
            while (!stack.isEmpty() && c < stack.peek() && last[stack.peek()] > i) {
                seen[stack.pop()] = false;
            }
            stack.push(c);
            seen[c] = true;
        }

        for (int c : stack)
            sb.append((char) (c + 'a'));

        return sb.toString();
    }
}
