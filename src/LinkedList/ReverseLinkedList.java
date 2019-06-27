package LinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverseList(next, head);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public ListNode reverseList3(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode prev) {
        if (head == null) return null;
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        return reverse(next, head);
    }

    public ListNode reverseList4(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
