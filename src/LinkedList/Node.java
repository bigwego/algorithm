package LinkedList;

public class Node {
    public int val;

    Node prev;

    public Node next;

    Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
