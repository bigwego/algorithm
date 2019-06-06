package LinkedList;

public class CountLinkedListNodes {

    public int countNodes(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
