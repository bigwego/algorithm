package BackTracking;

import java.math.BigInteger;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();

        for (int i = 1; i <= len / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                return false;
            }
            BigInteger num1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(i, j) <= len - i - j; j++) {
                if (num.charAt(j) == '0') {
                    break;
                }
                BigInteger num2 = new BigInteger(num.substring(i, i + j));
                if (isValid(num1, num2, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(BigInteger num1, BigInteger num2, int start, String num) {
        num2 = num2.add(num1);
        num1 = num2.subtract(num1);
        return num.startsWith(num2.toString(), start)
                && isValid(num1, num2, start + num2.toString().length(), num);
    }
}
