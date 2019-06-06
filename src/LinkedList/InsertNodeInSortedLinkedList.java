package LinkedList;

public class InsertNodeInSortedLinkedList {

    public ListNode insertNode(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null && curr.val < val) {
            prev = curr;
            curr = curr.next;
        }

        ListNode node = new ListNode(val);
        if (prev == null) {
            node.next = head;
            return node;
        }

        prev.next = node;
        node.next = curr;
        return head;
    }
}