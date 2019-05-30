package Stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.length() == 0 ? "" : sb.reverse().toString();
    }
}
