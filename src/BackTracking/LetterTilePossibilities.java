package BackTracking;

public class LetterTilePossibilities {

    public int numTilePossibilities(String tiles) {
        int[] cnts = new int[26];
        for (char c : tiles.toCharArray()) {
            cnts[c - 'A']++;
        }

        return dfs(cnts);
    }

    private int dfs(int[] cnts) {
        int sum = 0;

        for (int i = 0; i < 26; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            sum++;
            cnts[i]--;
            sum += dfs(cnts);
            cnts[i]++;
        }

        return sum;
    }
}
