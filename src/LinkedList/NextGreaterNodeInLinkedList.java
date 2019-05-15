package LinkedList;

import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        int cnt = 0;
        ListNode curr = head;
        while (curr != null) {
            cnt++;
            curr = curr.next;
        }
        int[] res = new int[cnt];
        int pos = 0;
        curr = head;
        Stack<Pair> stack = new Stack<>();

        while (curr != null) {
            while (!stack.isEmpty() && stack.peek().node.val < curr.val) {
                res[stack.pop().idx] = curr.val;
            }
            stack.push(new Pair(pos++, curr));
        }

        return res;
    }

    class Pair {
        Integer idx;

        ListNode node;

        Pair(Integer idx, ListNode node) {
            this.idx = idx;
            this.node = node;
        }
    }
}
