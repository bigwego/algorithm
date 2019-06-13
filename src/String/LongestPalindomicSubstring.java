package String;

// Problem 5
public class LongestPalindomicSubstring {

    int low;

    int max = 1;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        for (int i = 1, len = s.length(); i < len; i++) {
            expand(i - 1, i, s, len);
            expand(i, i, s, len);
        }

        return s.substring(low, low + max);
    }

    private void expand(int i, int j, String s, int len) {
        while (i > -1 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (j - i - 1 > max) {
            low = i + 1;
            max = j - i - 1;
        }
    }
}
