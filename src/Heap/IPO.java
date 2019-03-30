package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class IPO {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        PriorityQueue<int[]> cQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < Profits.length; i++) {
            cQueue.add(new int[]{ Capital[i], Profits[i] });
        }

        while (k-- > 0) {
            while (!cQueue.isEmpty() && cQueue.peek()[0] <= W) {
                pQueue.add(cQueue.poll());
            }
            if (pQueue.isEmpty()) {
                break;
            }
            W += pQueue.poll()[1];
        }
        return W;
    }
}
