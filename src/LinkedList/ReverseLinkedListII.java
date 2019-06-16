package LinkedList;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++)
            pre = pre.next;

        ListNode curr = pre.next;
        ListNode next = curr.next;

        for (int i = 0; i < n - m; i++) {
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = curr.next;
        }

        return dummy.next;
    }
}
