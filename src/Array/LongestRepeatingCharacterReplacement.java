package Array;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int start = 0, cnt = 0, maxLen = 0;
        int[] hash = new int[26];
        for (int end = 0; end < s.length(); end++) {
            cnt = Math.max(cnt, ++hash[s.charAt(end) - 'A']);
            if (end - start + 1 - cnt > k) {
                hash[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
