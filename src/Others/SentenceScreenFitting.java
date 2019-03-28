package Others;

public class SentenceScreenFitting {
    /**
     * @param sentence: a list of string
     * @param rows:     an integer
     * @param cols:     an integer
     * @return return an integer, denote times the given sentence can be fitted on the screen
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int cnt = 0, r = 0, c = 0, idx = 0;
        while (r < rows) {
            if (c + sentence[idx].length() <= cols) {
                c += sentence[idx++].length() + 1;
            } else {
                c = 0;
                r++;
            }
            if (idx == sentence.length) {
                cnt++;
                idx = 0;
            }
        }
        return cnt;
    }
}
