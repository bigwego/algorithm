public class WordSquares {
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!map.containsKey(prefix)) {
                    map.put(prefix, new ArrayList<>());
                }
                map.get(prefix).add(word);
            }
        }
        List<String> path = new ArrayList<>();
        for (String word : words) {
            path.add(word);
            dfs(res, path, 1, map, word.length());
            path.remove(path.size() - 1);
        }
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, int pre, Map<String, List<String>> map, int len) {
        if (pre == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        String prefix = "";
        for (String word : path) {
            prefix += word.charAt(pre);
        }
        if (!map.containsKey(prefix)) return;
        for (String next : map.get(prefix)) {
            path.add(next);
            dfs(res, path, pre + 1, map, len);
            path.remove(path.size() - 1);
        }
    }
}
