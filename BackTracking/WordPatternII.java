public class WordPatternII {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        return dfs(pattern, str, map);
    }

    private boolean dfs(String pattern, String str, Map<Character, String> map) {
        if (pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        char c = pattern.charAt(0);
        if (map.containsKey(c)) {
            if (str.startsWith(map.get(c))) {
                return dfs(pattern.substring(1), str.substring(map.get(c).length()), map);
            } else {
                return false;
            }
        }
        for (int i = 1; i <= str.length(); i++) {
            String sub = str.substring(0, i);
            if (map.containsValue(sub)) {
                return false;
            }
            map.put(c, sub);
            if (dfs(pattern.substring(1), str.substring(i), map)) {
                return true;
            }
            map.remove(c);
        }
        return false;
    }
}
