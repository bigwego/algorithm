package SlidingWindow;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int satisfy = 0;
        int len = customers.length;

        for (int i = 0, tmp = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                satisfy += customers[i];
            } else {
                tmp += customers[i];
            }
            if (i > X) {
                tmp -= grumpy[i - X] * customers[i - X];
            }
            res = Math.max(res, tmp);
        }

        return res + satisfy;
    }
}
