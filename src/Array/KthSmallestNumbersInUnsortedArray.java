package Array;

import java.util.PriorityQueue;

public class KthSmallestNumbersInUnsortedArray {

    public int kthSmallest(int k, int[] nums) {
        if (k > nums.length) {
            throw new IllegalArgumentException();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }

        int res = 0;
        while (k-- > 0) {
            res = queue.poll();
        }

        return res;
    }
}
