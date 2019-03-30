package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyFourGame {

    private final double eps = 0.001;

    private boolean res = false;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        help(list);
        return res;
    }

    private void help(List<Double> list) {
        if (res) {
            return;
        }
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < eps) {
                res = true;
            }
            return;
        }

        for (int i = 1, size = list.size(); i < size; i++) {
            for (int j = 0; j < i; j++) {
                List<Double> nexts = new ArrayList<>();
                double a = list.get(i);
                double b = list.get(j);
                nexts.addAll(Arrays.asList(a + b, a - b, b - a, a * b));
                if (Math.abs(a) > eps) {
                    nexts.add(b / a);
                }
                if (Math.abs(b) > eps) {
                    nexts.add(a / b);
                }
                list.remove(i);
                list.remove(j);
                for (double next : nexts) {
                    list.add(next);
                    help(list);
                    list.remove(list.size() - 1);
                }
                list.add(j, b);
                list.add(i, a);
            }
        }
    }

}