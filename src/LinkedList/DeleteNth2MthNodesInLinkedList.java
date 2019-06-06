package LinkedList;

public class DeleteNth2MthNodesInLinkedList {

    public ListNode deleteNode(ListNode head, int n, int m) {
        int idx = 0;
        ListNode from = null;

        while (idx++ < n) {
            if (from == null) {
                from = head;
            } else {
                from = from.next;
            }
        }

        ListNode to = head;
        idx = 0;
        while (idx++ <= m) {
            to = to.next;
        }

        if (from == null) {
            return to.next;
        } else {
            from.next = to.next;
            return from;
        }
    }
}
