package Heap;

import java.util.List;
import java.util.PriorityQueue;

public class SkipStones {

    public int getDistance(int n, int m, int target, List<Integer> d) {
        if (d == null || n == 0 || m >= n) {
            return target;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(d.get(0));
        queue.add(target - d.get(n));

        for (int i = 0; i < n - 1; i++) {
            queue.add(d.get(i + 1) - d.get(i));
        }

        while (m-- > 0) {
            queue.poll();
        }

        return queue.poll();
    }
}
