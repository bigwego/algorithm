package Stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : strs) {
            if (str.equals(".")) continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append("/").append(stack.pop());

        return sb.toString();
    }
}
