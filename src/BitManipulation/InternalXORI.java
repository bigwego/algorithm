package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class InternalXORI {

    public List<Integer> intervalXOR(int[] A, List<Interval> query) {
        List<Integer> res = new ArrayList<>(query.size());

        for (Interval q : query) {
            res.add(A[q.start] ^ A[q.start + 1]);
        }

        return res;
    }

    private class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
