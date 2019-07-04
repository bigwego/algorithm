package Others;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) return false;

        int rev = 0;
        while (x > rev) {
            rev = 10 * rev + x % 10;
            x /= 10;
        }

        return x == rev || x == rev / 10;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) return false;

        int rev = 0;

        while (x > rev) {
            rev = 10 * rev + x % 10;
            x /= 10;
        }

        return x == rev || x == rev / 10;
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        Object o = new Object();
        list.add(o);
        o = null;
        System.out.println(list.get(0) == null);
    }
}
