package LinkedList;

import java.util.Random;

public class LinkedListRandomNode {

    private final ListNode head;

    private final Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null,
     *             so it contains at least one node.
     */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode curr = head;
        int res = curr.val;
        for (int i = 1; curr.next != null; i++) {
            curr = curr.next;
            if (random.nextInt(i + 1) == i) {
                res = curr.val;
            }
        }
        return res;
    }
}
