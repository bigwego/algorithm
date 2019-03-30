package HashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        while (true) {
            int num = getHappy(n);
            if (num == 1) {
                return true;
            }
            if (!set.add(num)) {
                break;
            }
            n = num;
        }
        return false;
    }

    private int getHappy(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
