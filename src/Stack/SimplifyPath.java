package Stack;

import java.util.LinkedList;

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        if (strs.length == 0) return "/";

        LinkedList<String> stack = new LinkedList<>();
        for (String str : strs) {
            if (str.equals(".") || str.equals("")) continue;
            if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else stack.push(str);
        }

        if (stack.isEmpty()) return "/";

        String res = "";
        for (String str : stack)
            res = "/" + str + res;

        return res.equals("") ? "/" : res;
    }
}
