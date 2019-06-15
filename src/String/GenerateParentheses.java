package String;

// Problem 22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        help(res, "", n, n);
        return res;
    }

    private void help(List<String> res, String s, int open, int close) {
        if (open == 0 && close == 0) {
            res.add(s);
            return;
        }

        if (open > 0)
            help(res, s + "(", open - 1, close);

        if (close > open)
            help(res, s + ")", open, close - 1);
    }
}
