package Others;

import java.util.Stack;

public class AddingTwoNegabinaryNumbers {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int c = 0;
        Stack<Integer> stack = new Stack<>();

        while (i > -1 || j > -1 || c != 0) {
            int v1 = i > -1 ? arr1[i] : 0;
            int v2 = j > -1 ? arr2[j] : 0;
            c = v1 + v2 + c;
            stack.push(c & 1);
            c = -(c >> 1);
        }

        while (!stack.isEmpty() && stack.peek() == 0) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            return new int[1];
        }

        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pop();
        }

        return res;
    }
}
