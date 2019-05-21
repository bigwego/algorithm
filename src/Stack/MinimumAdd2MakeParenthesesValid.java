package Stack;

import java.util.Stack;

public class MinimumAdd2MakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    res++;
                }
            }
        }

        return res + stack.size();
    }
}
