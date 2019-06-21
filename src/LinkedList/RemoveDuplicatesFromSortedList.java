package LinkedList;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int num = curr.val;
                while (curr.next != null && curr.next.val == num)
                    curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;
    }
}
