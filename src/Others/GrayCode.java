package Others;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>(1 << n);
        res.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j > -1; j--) {
                res.add(res.get(j) | 1 << i);
            }
        }

        return res;
    }
}
