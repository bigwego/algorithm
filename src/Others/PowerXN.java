package Others;

// Problem 50. Pow(x, n)
public class PowerXN {

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        double res = myPow(x, n / 2);
        return (n & 1) == 0 ? res * res :
                n < 0 ? res * res * (1 / x) : res * res * x;
    }
}
