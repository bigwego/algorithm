package Stack;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(curr);
                curr = 0;
            } else {
                curr = stack.pop() + Math.max(2 * curr, 1);
            }
        }
        return curr;
    }
}
