package LinkedList;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode f = head.next;
        ListNode s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }
}
