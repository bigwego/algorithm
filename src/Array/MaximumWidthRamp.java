package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumWidthRamp {

    public int maxWidthRamp(int[] A) {
        int len = A.length;
        List<Integer> list = new ArrayList<>(len);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0 || A[i] < A[list.get(list.size() - 1)]) {
                list.add(i);
            } else {
                int l = 0;
                int r = list.size() - 1;
                int num = A[i];
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (A[list.get(mid)] <= num) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                res = Math.max(res, i - list.get(l));
            }
        }
        return res;
    }

    public int maxWidthRamp2(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (i == 0 || A[i] < A[stack.peek()]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = len - 1; i > res; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }
}
