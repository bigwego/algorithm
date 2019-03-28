public class Solution {
    /**
     * @param a: a positive integer
     * @return: the smallest positive integer whose multiplication of each digit equals to a
     */
    public int MinimumFactorization(int a) {
        long res = 0, base = 1;
        for (int i = 9; i > 1; i--) {
            while (a % i == 0) {
                res += i * base;
                base *= 10;
                a /= i;
            }
            if (res > Integer.MAX_VALUE) return 0;
        }
        return a == 1 ? (int) res : 0;
    }
}
