package LinkedList;

/**
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node prev;
 * public Node next;
 * public Node child;
 * <p>
 * public Node() {}
 * <p>
 * public Node(int _val,Node _prev,Node _next,Node _child) {
 * val = _val;
 * prev = _prev;
 * next = _next;
 * child = _child;
 * }
 * };
 */
public class FlattenMultilevelDoublyLinkedList {

    private Node flatten(Node head) {
        Node p = head;
        while (p != null) {
            if (p.child != null) {
                Node right = p.next;
                p.next = flatten(p.child);
                p.next.prev = p;
                p.child = null;
                while (p.next != null) {
                    p = p.next;
                }
                if (right != null) {
                    p.next = right;
                    p.next.prev = p;
                }
            }
            p = p.next;
        }
        return head;
    }
}
