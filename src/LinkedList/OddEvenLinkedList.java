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

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

}
