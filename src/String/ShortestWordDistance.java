package String;

public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int idx1 = -1, idx2 = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (idx2 != -1) {
                    res = Math.min(res, i - idx2);
                }
                idx1 = i;
            } else if (words[i].equals(word2)) {
                if (idx1 != -1) {
                    res = Math.min(res, i - idx1);
                }
                idx2 = i;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
