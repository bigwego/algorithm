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

    public int longestSubstring2(String s, int k) {
        int res = 0;

        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++)
            res = Math.max(res, longestSubstringWithUniqueChars(s, k, uniqueTarget));

        return res;
    }

    private int longestSubstringWithUniqueChars(String s, int k, int uniqueTarget) {
        int[] cnts = new int[26];
        int unique = 0, noLessThanK = 0;
        int i = 0, j = 0, len = s.length(), idx = 0;
        int res = 0;

        while (j < len) {
            idx = s.charAt(j) - 'a';
            if (cnts[idx]++ == 0) unique++;
            if (cnts[idx++] == k) noLessThanK++;

            while (unique > uniqueTarget) {
                if (cnts[s.charAt(i) - 'a']-- == k) noLessThanK--;
                if (cnts[s.charAt(i++) - 'a'] == 0) unique--;
            }

            if (unique == uniqueTarget && unique == noLessThanK)
                res = Math.max(res, j - i);
        }

        return res;
    }
}
