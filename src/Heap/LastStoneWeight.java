package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int s : stones) {
            queue.add(s);
        }
        while (queue.size() > 1) {
            int s1 = queue.poll();
            int s2 = queue.poll();
            if (s1 != s2) {
                queue.add(s1 > s2 ? s1 - s2 : s2 - s1);
            }
        }

        return queue.isEmpty() ? 0 : queue.poll();
    }
}
