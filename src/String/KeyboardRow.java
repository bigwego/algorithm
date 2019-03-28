class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String[] lines = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            for (char c : lines[i].toCharArray()) {
                map.put(c, i);
            }
        }
        for (String word : words) {
            if (word == "") continue;
            String w = word.toLowerCase();
            int idx = map.get(w.charAt(0));
            for (char c : w.toCharArray()) {
                if (map.get(c) != idx) {
                    idx = -1;
                    break;
                }
            }
            if (idx != -1) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
