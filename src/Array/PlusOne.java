package Array;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int c = 0;
        for (int i = digits.length - 1; i > -1; i--) {
            digits[i]++;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
