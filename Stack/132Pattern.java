class 132Pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int two = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] < two) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                two = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
