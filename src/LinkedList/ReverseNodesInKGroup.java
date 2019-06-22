package LinkedList;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), start = dummy;
        dummy.next = head;

        while (true) {
            ListNode prev = start, next = prev;
            start = prev.next;
            ListNode curr = prev.next;

            for (int i = 0; i < k && next != null; i++)
                next = next.next;

            if (next == null) break;

            for (int i = 0; i < k - 1; i++) {
                curr = prev.next;
                prev.next = curr.next;
                curr.next = next.next;
                next.next = curr;
            }
        }

        return dummy.next;
    }
}
