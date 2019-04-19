package String;

public class LongestSubstringWithAtLeastKRepeatingChars {

    public int longestSubstring(String s, int k) {
        int i = 0;
        int len = s.length();
        int res = 0;
        while (i + k <= len) {
            int[] hash = new int[26];
            int mask = 0, max_j = i;
            for (int j = i; j < len; j++) {
                int idx = s.charAt(j) - 'a';
                hash[idx]++;
                if (hash[idx] < k) {
                    mask |= (1 << idx);
                } else {
                    mask &= (~(1 << idx));
                }
                if (mask == 0) {
                    res = Math.max(res, j - i + 1);
                    max_j = j;
                }
            }
            i = max_j + 1;
        }
        return res;
    }
}
