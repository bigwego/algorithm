package Others;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int res = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            res = 26 * res + chs[i] - 'A' + 1;
        }
        return res;
    }
}