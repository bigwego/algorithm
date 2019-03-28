class SlidingWindowMaximum {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[]{};
            }
            int len = nums.length, idx = 0;
            int[] res = new int[len - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
                while (queue.peekFirst() < i - k + 1) {
                    queue.pollFirst();
                }
                if (i + 1 >= k) {
                    res[idx++] = nums[queue.peekFirst()];
                }
            }
            return res;
        }
    }
