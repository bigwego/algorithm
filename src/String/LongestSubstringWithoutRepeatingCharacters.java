package String;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] cnts = new int[256];
        int res = 1;
        int i = 0;

        for (int j = 0, len = s.length(); j < len; j++) {
            int idx = s.charAt(j);
            cnts[idx]++;
            while (cnts[idx] == 2) {
                cnts[s.charAt(i++)]--;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, res = 1;
        int[] cnts = new int[256];

        for (int j = 0, len = s.length(); j < len; j++) {
            int idx = s.charAt(j);
            cnts[idx]++;
            while (cnts[idx] == 2) {
                cnts[s.charAt(i++)]--;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
