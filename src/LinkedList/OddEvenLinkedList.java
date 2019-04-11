package LinkedList;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        while (evenTail != null && evenTail.next != null) {
            odd.next = evenTail.next;
            odd = odd.next;
            evenTail.next = odd.next;
            evenTail = evenTail.next;
        }
        odd.next = evenHead;
        return head;
    }
}
