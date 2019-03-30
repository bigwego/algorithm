package DFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int[] cnts = getParenthesesDiff(s);
        dfs(res, s, 0, cnts[0], cnts[1]);
        return res;
    }

    private void dfs(List<String> res, String s, int start, int open, int close) {
        if (open == 0 && close == 0 && isValid(s)) {
            res.add(s);
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' && open > 0) {
                dfs(res, s.substring(0, i) + s.substring(i + 1), i, open - 1, close);
            }
            if (s.charAt(i) == ')' && close > 0) {
                dfs(res, s.substring(0, i) + s.substring(i + 1), i, open, close - 1);
            }
        }
    }

    private boolean isValid(String s) {
        int[] res = getParenthesesDiff(s);
        return res[0] == 0 && res[1] == 0;
    }

    private int[] getParenthesesDiff(String s) {
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '(') {
                res[0]++;
            } else if (c == ')') {
                if (res[0] > 0) {
                    res[0]--;
                } else {
                    res[1]++;
                }
            }
        }
        return res;
    }
}
