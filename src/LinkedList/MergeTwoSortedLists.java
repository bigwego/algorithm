package LinkedList;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                tail.next = l1 == null ? l2 : l1;
                if (l1 == null) l2 = l2.next;
                else l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
            }
            tail = tail.next;
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
