package String;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1, end = j;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().append(s).toString();
    }
}
