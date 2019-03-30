package SlidingWindow;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int[] hash = new int[26];
        for (char c : s1.toCharArray()) {
            hash[c - 'a']++;
        }
        for (int l = 0, r = 0; r < s2.length(); r++) {
            if (--hash[s2.charAt(r) - 'a'] < 0) {
                while (++hash[s2.charAt(l++) - 'a'] != 0) {
                }
            } else if (r - l + 1 == s1.length()) {
                return true;
            }
        }
        return s1.length() == 0;
    }
}
