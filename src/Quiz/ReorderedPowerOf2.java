package Quiz;

public class ReorderedPowerOf2 {

    public boolean reorderedPowerOf2(int N) {
        long cnt = getCount(N);
        for (int i = 0; i < 32; i++) {
            if (getCount(1 << i) == cnt) {
                return true;
            }
        }
        return false;
    }

    private long getCount(int n) {
        long cnt = 0L;
        while (n > 0) {
            cnt += Math.pow(10, n % 10);
            n /= 10;
        }
        return cnt;
    }
}
