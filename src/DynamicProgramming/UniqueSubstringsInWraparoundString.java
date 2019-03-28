class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] hash = new int[26];
        int maxLen = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) == p.charAt(i - 1) + 1 || p.charAt(i) == p.charAt(i - 1) - 25)) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            hash[p.charAt(i) - 'a'] = Math.max(hash[p.charAt(i) - 'a'], maxLen);
        }
        int res = 0;
        for (int num : hash) {
            res += num;
        }
        return res;
    }
}
