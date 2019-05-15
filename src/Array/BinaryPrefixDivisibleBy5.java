package Array;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        int len = A.length;
        List<Boolean> res = new ArrayList<>(len);
        if (len == 0) {
            return res;
        }

        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = (tmp * 2 + A[i]) % 5;
            res.add(tmp % 5 == 0 ? true : false);
        }
        return res;
    }
}
