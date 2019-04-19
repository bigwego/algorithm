package Others;

public class SuperPow {

    public int superPow(int a, int[] b) {
        int idx = 0, weight = 1;
        for (int i = b.length - 1; i > -1; i--) {
            idx += b[i] * weight;
            weight *= 10;
        }
        return (int) Math.pow(a, idx) % 1337;
    }
}
