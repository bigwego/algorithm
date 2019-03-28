class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                else return o2.length() - o1.length();
            }
        });
        for (String word : d) {
            int idx = 0;
            for (char c : s.toCharArray()) {
                if (idx<word.length() && c == word.charAt(idx)) idx++;
            }
            if (idx == word.length()) return word;
        }
        return "";
    }
}
