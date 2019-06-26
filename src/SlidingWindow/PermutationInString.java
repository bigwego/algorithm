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

    public boolean checkInclusion2(String s1, String s2) {
        int[] cnts = new int[26];
        for (char c : s1.toCharArray()) cnts[c - 'a']++;

        int i = 0;
        for (int j = 0, len = s2.length(); j < len; j++) {
            if (--cnts[s2.charAt(j) - 'a'] < 0) {
                while (++cnts[s2.charAt(i++) - 'a'] != 0) {
                }
            } else if (j - i == s1.length() - 1) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        int[] cnts = new int[26];

        for (char c : s1.toCharArray())
            cnts[c - 'a']++;

        int i = 0;
        for (int j = 0, len = s2.length(); j < len; j++) {
            int idx = s2.charAt(j) - 'a';
            cnts[idx]--;
            while (cnts[idx] < 0) {
                cnts[s2.charAt(i++) - 'a']++;
            }
            if (j - i == s1.length() - 1) return true;
        }

        return false;
    }
}
