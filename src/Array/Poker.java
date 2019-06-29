package Array;

public class Poker {

    public int getAns(int[] cards) {
        if (cards == null || cards.length == 0) return 0;

        int[] cnts = new int[10];
        for (int card : cards) cnts[card]++;

        int res = 0;

        for (int i = 1; i < 6; i++) {
            while (cnts[i] > 0) {
                int j = i + 1;
                while (j < 10 && cnts[j] > 0) j++;
                if (j - i > 4) {
                    process(cnts, i, j);
                    res++;
                } else break;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (cnts[i] > 1) {
                res++;
                cnts[i] = 0;
            }
        }

        for (int i = 1; i < 10; i++) {
            res += cnts[i];
        }

        return res;
    }

    private void process(int[] cnts, int i, int j) {
        while (i < j) cnts[i++]--;
    }
}
