package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private final PriorityQueue<Integer> maxHeap;

    private final PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1 - arg0;
            }

        });
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            maxHeap.offer(num);
        } else if (minHeap.size() == 0 || num >= minHeap.peek()) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            minHeap.offer(num);
        } else {
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
