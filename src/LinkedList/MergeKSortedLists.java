package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) {
                queue.add(curr.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode dummy = new ListNode(0), tail = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            tail.next = curr;
            tail = tail.next;
            if (curr.next != null) queue.add(curr.next);
        }

        return dummy.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int l, int r) {
        if (l >= r) return lists[l];

        int mid = l + (r - l) / 2;
        ListNode l1 = partition(lists, l, mid);
        ListNode l2 = partition(lists, mid + 1, r);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
