package LinkedList;

public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy, fast = dummy;
        while (fast != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }
        while (slow != null) {
            slow.val = (slow.val + 1) % 10;
            slow = slow.next;
        }
        return dummy.next.val == 0 ? dummy : dummy.next;
    }
}
