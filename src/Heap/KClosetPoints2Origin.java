package Heap;

import java.util.PriorityQueue;

public class KClosetPoints2Origin {

    public int[][] kCloset(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0] * p1[0] + p1[1] * p1[1], p2[0] * p2[0] + p2[1] * p2[1]));

        for (int[] p : points) {
            queue.add(p);
        }

        int[][] res = new int[K][2];
        int idx = 0;
        while (idx < K) {
            res[idx++] = queue.poll();
        }
        return res;
    }
}
