class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        List<Character>[] freqs = new List[s.length() + 1];
        for (char c : map.keySet()) {
            if (freqs[map.get(c)] == null) {
                freqs[map.get(c)] = new ArrayList<>();
            }
            freqs[map.get(c)].add(c);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = freqs.length - 1; i > 0; i--) {
            if (freqs[i] != null) {
                for (char c : freqs[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
