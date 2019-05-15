package Quiz;

public class SmallestIntegerDivisibleByK {

    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int r = 0;
        for (int i = 1; i <= K; i++) {
            r = (10 * r + 1) % K;
            if (r == 0) {
                return i;
            }
        }
        return -1;
    }
}
