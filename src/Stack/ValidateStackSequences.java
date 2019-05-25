package Stack;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (j < len) {
            if (stack.isEmpty()) {
                if (i < len) {
                    stack.push(pushed[i++]);
                } else {
                    return false;
                }
            }
            while (stack.peek() != popped[j] && i < len) {
                stack.push(pushed[i++]);
            }
            if (i == len && stack.peek() != popped[j]) {
                return false;
            } else {
                stack.pop();
                j++;
            }
        }

        return true;
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
