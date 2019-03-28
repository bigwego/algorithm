class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        char res = ' ';
        for (char c : t.toCharArray()) {
            if (hash[c - 'a'] == 0) {
                res = c;
                break;
            }else {
                hash[c - 'a']--;
            }
        }
        return res;
    }
}
