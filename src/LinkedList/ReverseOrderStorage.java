package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseOrderStorage {

    public List<Integer> reverseStore(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        List<Integer> res = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }
}
