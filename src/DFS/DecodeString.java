package DFS;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        Stack<String> strStack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();
        int cnt = 0;
        int len = s.length();
        int idx = 0;
        String tmp = "";
        while (idx < len) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                cnt = 10 * cnt + c - '0';
            } else if (c == '[') {
                strStack.push(tmp);
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int repeat = cntStack.pop();
                while (repeat-- > 0) {
                    sb.append(tmp);
                }
                tmp = sb.toString();
            } else {
                tmp += c;
            }
            idx++;
        }
        return tmp;
    }
}
