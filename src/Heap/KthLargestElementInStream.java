package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private PriorityQueue<Integer> queue;

    private int k;

    public KthLargestElementInStream(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) queue.poll();
        }
    }

    public int add(int val) {
        queue.add(val);
        if(queue.size()>k) queue.poll();
        return queue.peek();
    }
}
