package String;

public class PalindromicSubstrings {

    private int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0, len = s.length(); i < len; i++) {
            help(s, i, i + 1);
            help(s, i, i);
        }
        return cnt;
    }

    private void help(String s, int l, int r) {
        int len = s.length();
        while (l > -1 && r < len && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }
    }
}
