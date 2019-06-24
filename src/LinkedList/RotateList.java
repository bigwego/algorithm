package LinkedList;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode curr = head, tail = null;
        int cnt = 0;

        while (curr != null) {
            cnt++;
            tail = curr;
            curr = curr.next;
        }

        k %= cnt;
        if (k == 0) return head;

        k = cnt - k;
        curr = head;
        while (k-- > 0) {
            ListNode next = curr.next;
            tail.next = curr;
            tail = tail.next;
            curr = next;
        }

        return curr;
    }
}
