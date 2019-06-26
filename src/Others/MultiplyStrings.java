package Others;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        char[] chs1 = num1.toCharArray(), chs2 = num2.toCharArray();
        int len1 = chs1.length, len2 = chs2.length;
        int[] digits = new int[len1 + len2];

        for (int i = len1 - 1; i > -1; i--) {
            for (int j = len2 - 1; j > -1; j--) {
                int p = (chs1[i] - '0') * (chs2[j] - '0') + digits[i + j + 1];
                digits[i + j + 1] = p % 10;
                digits[i + j] += p / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            if (sb.length() == 0 && digit == 0) continue;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply2(String num1, String num2) {
        char[] chs1 = num1.toCharArray(), chs2 = num2.toCharArray();
        int len1 = chs1.length, len2 = chs2.length;
        int[] digits = new int[len1 + len2];

        for (int i = len1 - 1; i > -1; i--) {
            for (int j = len2 - 1; j > -1; j--) {
                int p = (chs1[i] - '0') * (chs2[j] - '0') + digits[i + j + 1];
                digits[i + j + 1] = p % 10;
                digits[i + j] += p / 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0, len = digits.length; i < len; i++) {
            if (sb.length() == 0 && digits[i] == 0) continue;
            sb.append(digits[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
