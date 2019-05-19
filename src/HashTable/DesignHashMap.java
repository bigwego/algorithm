package HashTable;

public class DesignHashMap {

    private final Node[] nodeList;

    public DesignHashMap() {
        nodeList = new Node[1000];
    }

    public void put(int key, int val) {
        int idx = key % 1000;
        Node node = nodeList[idx];
        if (node == null) {
            nodeList[idx] = new Node(key, val);
        } else {
            nodeList[idx] = new Node(key, val);
            nodeList[idx].next = node;
        }
    }

    public int get(int key) {
        int idx = key % 1000;
        Node node = nodeList[idx];
        while (node != null && node.key != key) {
            node = node.next;
        }
        return node == null ? -1 : node.val;
    }

    public void remove(int key) {
        int idx = key % 1000;
        Node node = nodeList[idx];
        Node prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if (prev == null) {
            nodeList[idx] = null;
            return;
        }
        if (node != null) {
            prev.next = node.next;
        } else {
            prev.next = null;
        }
    }

    class Node {
        int key;

        int val;

        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
