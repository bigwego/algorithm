package BitManipulation;

public class ConvertNumberToHexadecimal {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String res = "";
        int len = 0;
        while (num != 0 && len < 8) {
            int bit = num & 0xf;
            if (bit < 10) {
                res = (char) ('0' + bit) + res;
            } else {
                res = (char) ('a' + bit - 10) + res;
            }
            num >>= 4;
            len++;
        }
        return res;
    }
}
