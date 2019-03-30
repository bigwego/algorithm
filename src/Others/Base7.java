package Others;

public class Base7 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean positive = true;
        if (num < 0) {
            positive = false;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num /= 7;
        }
        if (!positive) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
