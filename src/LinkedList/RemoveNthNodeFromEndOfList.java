package LinkedList;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode curr = head;
        ListNode prev = null;

        while (n-- > 1) {
            f = f.next;
        }

        while (f.next != null) {
            f = f.next;
            prev = curr;
            curr = curr.next;
        }

        ListNode ret;
        if (prev == null) {
            ret = curr.next;
            curr.next = null;
        } else {
            prev.next = curr.next;
            ret = head;
        }

        return ret;
    }
}
