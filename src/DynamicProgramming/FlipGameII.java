public class FlipGameII {
    /**
     * @param s: the given string
     * @return: if the starting player can guarantee a win
     */
    Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                if (!canWin(s.substring(0, i) + "--" + s.substring((i + 2)))) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
