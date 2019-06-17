package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))
                    dp[j][i] = true;
            }
        }

        help(res, new ArrayList<String>(), dp, 0, s);
        return res;
    }

    private void help(List<List<String>> res, ArrayList<String> list, boolean[][] dp, int idx, String s) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx, len = s.length(); i < len; i++) {
            if (dp[idx][i]) {
                list.add(s.substring(idx, i + 1));
                help(res, list, dp, i + 1, s);
                list.remove(list.size() - 1);
            }
        }
    }
}
