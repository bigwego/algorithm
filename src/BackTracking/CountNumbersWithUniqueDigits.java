package BackTracking;

import java.util.HashSet;

public class CountNumbersWithUniqueDigits {

    int res = 0;

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 2) {
            return (int) Math.pow(10, n);
        }
        help(new HashSet<>(), n);
        return res;
    }

    private void help(HashSet<Integer> digits, int n) {
        if (digits.size() > 0) {
            res++;
        }
        if (digits.size() == n) {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!digits.contains(i)) {
                digits.add(i);
                help(digits, n);
                digits.remove(i);
            }
        }
    }
}
