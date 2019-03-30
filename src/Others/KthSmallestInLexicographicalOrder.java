package Others;

public class KthSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        k--;
        int curr = 1;
        while (k > 0) {
            int step = calc(n, curr, curr + 1);
            if (step <= k) {
                curr++;
                k -= step;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    private int calc(int n, long n1, long n2) {
        int step = 0;
        while (n1 <= n) {
            step += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }
}
