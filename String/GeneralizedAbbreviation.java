public class GeneralizedAbbreviation {
    /**
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */
    List<String> res = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {
        dfs(word, new ArrayList<Character>(), 0);
        return res;
    }

    private void dfs(String word, ArrayList<Character> chs, int idx) {
        if (idx == word.length()) {
            res.add(genStr(chs));
            return;
        }
        chs.add(word.charAt(idx));
        dfs(word, chs, idx + 1);
        chs.remove(chs.size() - 1);

        chs.add('1');
        dfs(word, chs, idx + 1);
        chs.remove(chs.size() - 1);
    }

    private String genStr(ArrayList<Character> chs) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < chs.size()) {
            if (chs.get(idx) == '1') {
                int cnt = 0;
                while (idx < chs.size() && chs.get(idx) == '1') {
                    cnt++;
                    idx++;
                }
                sb.append(cnt);
            } else {
                sb.append(chs.get(idx++));
            }
        }
        return sb.toString();
    }
}
