public class OneEditDistance {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int len = Math.min(s.length(), t.length());
        boolean res = true;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                res = s.substring(i + 1).equals(t.substring(i)) ||
                        s.substring(i).equals(t.substring(i + 1)) ||
                        s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return res;
    }
}
