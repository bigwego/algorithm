package Stack;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int res = 0;

        for (int j = 0, len = s.length(); j < len; j++) {
            char c = s.charAt(j);
            if (c == '(') {
                stack.push(j);
            } else {
                if (stack.isEmpty()) {
                    i = j + 1;
                } else {
                    int idx = stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, j - i + 1);
                    } else {
                        res = Math.max(res, j - stack.peek());
                    }
                }
            }
        }

        return res;
    }
}
