package String;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] cnts = new int[256];
        int i = 0, j = 0, len = s.length(), res = len + 1, cnt = t.length();
        int from = 0, to = 0;

        for (char c : t.toCharArray()) cnts[c]++;

        while (j < len) {
            if (--cnts[s.charAt(j)] >= 0) cnt--;
            while (cnt == 0) {
                if (j - i + 1 < res) {
                    res = j - i + 1;
                    from = i;
                    to = j;
                }
                if (++cnts[s.charAt(i++)] > 0) cnt++;
            }
            j++;
        }

        return res == len + 1 ? "" : s.substring(from, to + 1);
    }
}
