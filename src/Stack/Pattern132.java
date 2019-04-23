package Stack;

import java.util.Stack;

public class Pattern132 {

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

    public boolean find132pattern2(int[] nums) {
        int len = nums.length;
        int top = len;
        int[] stack = new int[len];
        int second = Integer.MIN_VALUE;
        for (int i = len - 1; i > -1; i--) {
            if (nums[i] < second) {
                return true;
            }
            while (top < len && stack[top] < nums[i]) {
                second = stack[top++];
            }
            stack[--top] = nums[i];
        }
        return false;
    }
}
