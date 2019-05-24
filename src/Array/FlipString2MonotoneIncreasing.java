package Array;

public class FlipString2MonotoneIncreasing {

    public int minFlipsMonoIncr(String S) {
        int cntOnes = 0;
        int cntFlips = 0;
        for (char c : S.toCharArray()) {
            if (c == '1') {
                cntOnes++;
            } else {
                cntFlips++;
            }
            cntFlips = Math.min(cntFlips, cntOnes);
        }

        return cntFlips;
    }
}
