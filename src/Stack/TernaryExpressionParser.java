package Stack;

public class TernaryExpressionParser {

    public String parseTernary(String expression) {
        char[] stack = new char[5000];
        int top = 0;
        for (int i = expression.length(); i > -1; i--) {
            if (expression.charAt(i) == '?') {
                i--;
                top--;
                if (expression.charAt(i) == 'T') {
                    stack[top - 1] = stack[top];
                }
            } else if (expression.charAt(i) != ':') {
                stack[top++] = expression.charAt(i);
            }
        }
        return String.valueOf(stack[0]);
    }
}
