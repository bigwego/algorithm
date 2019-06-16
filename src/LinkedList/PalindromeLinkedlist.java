package LinkedList;

public class PalindromeLinkedlist {

    public boolean isPalindrome(ListNode head) {
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        if (f == null) s = s.next;

        s = reverseList(s);
        f = head;

        while (s != null) {
            if (f.val != s.val) return false;
            f = f.next;
            s = s.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
