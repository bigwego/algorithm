import java.util.Random;

class RandomPickWithWeight {
    int[] sum;

    private Random rand;

    public RandomPickWithWeight(int[] w) {
        sum = new int[w.length];
        rand = new Random();
        int tmp = 0;
        for (int i = 0; i < sum.length; i++) {
            tmp += w[i];
            sum[i] = tmp;
        }
    }

    public int pickIndex() {
        int idx = rand.nextInt(sum[sum.length - 1]) + 1;
        int left = 0, right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == idx) {
                return mid;
            } else if (sum[mid] < idx) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
