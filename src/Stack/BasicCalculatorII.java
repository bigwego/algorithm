package Stack;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chs = s.toCharArray();
        char sign = '+';
        int res = 0, num = 0, len = chs.length, idx = 0;

        while (idx < len) {
            if (Character.isDigit(chs[idx])) {
                num = num * 10 + chs[idx] - '0';
            }
            if ((!Character.isDigit(chs[idx]) && chs[idx] != ' ') || idx == len - 1) {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*') stack.push(stack.pop() * num);
                else stack.push(stack.pop() / num);
                num = 0;
                sign = chs[idx];
            }
            idx++;
        }

        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
