package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfSquarefulArrays {

    private int cnt = 0;

    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        help(new ArrayList<>(), new boolean[A.length], A, -1);
        return cnt;
    }

    private void help(ArrayList<Integer> list, boolean[] used, int[] A, int lastNumber) {
        if (list.size() == A.length) {
            cnt++;
            return;
        }
        for (int i = 0, len = A.length; i < len; i++) {
            if (used[i] || (i > 0 && A[i] == A[i - 1] && !used[i - 1])) {
                continue;
            }
            if (lastNumber != -1) {
                if (!isSquare(lastNumber, A[i])) {
                    continue;
                }
            }
            used[i] = true;
            list.add(A[i]);
            help(list, used, A, A[i]);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    private boolean isSquare(int a, int b) {
        double sqrt = Math.sqrt(a + b);
        return sqrt - Math.floor(sqrt) == 0;
    }
}
