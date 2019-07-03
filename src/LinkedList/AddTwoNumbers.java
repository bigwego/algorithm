package LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            ListNode newNode = new ListNode(0);
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            newNode.val = sum % 10;
            sum /= 10;
            tail.next = newNode;
            tail = tail.next;
        }
        if (sum != 0) {
            tail.next = new ListNode(sum);
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode(0), tail = dummy;
        int c = 0;

        while (l1 != null && l2 != null) {
            c += l1.val + l2.val;
            tail.next = new ListNode(c % 10);
            c /= 10;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 == null) {
            if (c != 0) tail.next = new ListNode(c);
            return dummy.next;
        }

        ListNode next = l1 != null ? l1 : l2;
        while (c > 0 && next != null) {
            c += l1.val;
            l1.val = c % 10;
            c /= 10;
            next = next.next;
        }

        if (c != 0) next.next = new ListNode(c);

        tail.next = next;
        return dummy.next;
    }
}
