package Array;

import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};

        int len = nums.length;
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int idx = 0;

        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
                queue.pollLast();
            queue.addLast(i);
            if (i + 1 >= k) {
                if (queue.peekFirst() == i - k)
                    queue.pollFirst();
                res[idx++] = nums[queue.peekFirst()];
            }
        }

        return res;
    }
}
