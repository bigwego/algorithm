class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                if (stack.isEmpty()) {
                    res = Math.max(res, height * i);
                } else {
                    res = Math.max(res, height * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            if (stack.isEmpty()) {
                res = Math.max(res, height * heights.length);
            } else {
                res = Math.max(res, height * (heights.length - stack.peek() - 1));
            }
        }
        return res;
    }
}
