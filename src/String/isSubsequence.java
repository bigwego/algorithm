package String;

public class isSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (t.length() > s.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();
        while (j < n) {
            if (t.charAt(j) == s.charAt(i)) {
                j++;
                i++;
            } else {
                j++;
            }
            if (i == m) {
                return true;
            }
        }
        return false;
    }
}
