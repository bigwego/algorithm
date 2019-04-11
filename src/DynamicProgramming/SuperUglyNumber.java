package DynamicProgramming;

public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] ugly = new int[n];
        int[] idx = new int[k];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                ugly[i] = Math.min(ugly[i], ugly[idx[j]] * primes[j]);
            }
            for (int j = 0; j < k; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) {
                    idx[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}
