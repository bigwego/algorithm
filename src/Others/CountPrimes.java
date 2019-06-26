package Others;

public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 2) return 0;

        boolean[] notPrime = new boolean[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; j * i < n; j++)
                    notPrime[j * i] = true;
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) res++;
        }

        return res;
    }

    public int countPrimes2(int n) {
        if (n < 2) return 0;

        boolean[] notPrime = new boolean[n];
        int res = 0;

        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; j * i < n; j++)
                    notPrime[j * i] = true;
            }
        }

        return res;
    }
}
