public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                c -= offset;
                if (c < 'a') {
                    c += 26;
                }
                sb.append(c);
            }
            String s = sb.toString();
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
