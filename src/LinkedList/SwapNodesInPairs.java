package LinkedList;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next, next = newHead.next;
        newHead.next = head;
        head.next = swapPairs(next);
        return newHead;
    }
}
