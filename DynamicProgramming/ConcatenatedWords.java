class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return null;
        }
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if(word.length()==0) {
                continue;
            }
            set.remove(word);
            if (isValid(word, set)) {
                res.add(word);
            }
            set.add(word);
        }
        return res;
    }

    private boolean isValid(String word, Set<String> set) {
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = i - 1; j > -1; j--) {
                if (dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
