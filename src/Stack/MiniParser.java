package Stack;

import java.util.List;
import java.util.Stack;

public class MiniParser {

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0;
        for (int r = 0, len = s.length(); r < len; r++) {
            char c = s.charAt(r);
            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r + 1;
            } else if (c == ']') {
                String num = s.substring(l, r);
                if (!num.equals("")) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r + 1;
            } else if (c == ',') {
                if (s.charAt(r - 1) != ']') {
                    curr.add(new NestedInteger(Integer.valueOf(s.substring(l, r))));
                }
                l = r + 1;
            }
        }
        return curr;
    }

    private class NestedInteger {

        NestedInteger(int val) {
        }

        NestedInteger() {
        }

        boolean isInteger() {
            return true;
        }


        Integer getInteger() {
            return 1;
        }

        void setInteger(int value) {
        }

        List<NestedInteger> getList() {
            return null;
        }

        void add(NestedInteger ni) {
        }
    }
}
