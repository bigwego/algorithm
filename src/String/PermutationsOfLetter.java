package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfLetter {

    public String[] permute(String S) {
        List<String> res = new ArrayList<>();
        res.add("");
        int idx = 0;
        int len = S.length();

        while (idx < len) {
            List<String> next = new ArrayList<>();
            if (S.charAt(idx) == '{') {
                int close = idx + 1;
                while (S.charAt(close) != '}') close++;
                String tmp = S.substring(idx + 1, close);
                for (String s : res) {
                    for (String c : tmp.split(",")) {
                        next.add(s + c);
                    }
                }
                res = next;
                idx = close + 1;
            } else {
                int close = idx + 1;
                while (close < len && S.charAt(close) != '{') close++;
                String tmp = S.substring(idx, close);
                for (String s : res) {
                    next.add(s + tmp);
                }
                res = next;
                if (close == len) break;
                idx = close;
            }
        }

        Collections.sort(res);
        String[] strs = new String[res.size()];

        for (int i = 0, l = strs.length; i < l; i++)
            strs[i] = res.get(i);

        return strs;
    }
}
