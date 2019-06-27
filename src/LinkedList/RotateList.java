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

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode tail = null, curr = head;
        int cnt = 0;

        while (curr != null) {
            tail = curr;
            curr = curr.next;
            cnt++;
        }

        if (cnt % k == 0) return head;

        k = cnt % k;
        k = cnt - k;

        curr = head;

        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = null;
            tail.next = curr;
            tail = tail.next;
            curr = next;
        }

        return curr;
    }
}
