package Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head;

    Node tail;

    Map<Integer, Node> map;

    int cap;

    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        int val = node.value;
        removeNode(node);
        addToHead(node);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
            return;
        }

        Node node = new Node(head, head.next, key, value);
        map.put(key, node);
        if (size == cap) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
        addToHead(node);
        size = size == cap ? size : size + 1;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
    }

    private class Node {
        Node prev;

        Node next;

        int key;

        int value;

        public Node() {
        }

        public Node(Node prev, Node next, int key, int value) {
            this.prev = prev;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
