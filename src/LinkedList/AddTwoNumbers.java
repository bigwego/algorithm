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
}
