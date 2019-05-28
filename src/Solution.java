import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final Map<Integer, Node> map = new HashMap<>();

    private static final Node head = new Node();

    private static final Node tail = new Node();

    private static final int count = 0;

    static {
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while (!(input = br.readLine()).equals("exit")) {
            String[] strs = input.split(" ");

            // get or remove
            if (strs.length == 2) {
                int key = Integer.valueOf(strs[1]);
                int val = get(key);

                // get
                if (strs[0].equals("get")) {
                    System.out.println(get(key));
                }

                // remove
                else {
                    if (val == -1) {
                        System.out.println(key);
                    } else {
                        Node node = map.get(key);
                        remove(node);
                        System.out.println(node.val);
                    }
                }
            }

            // add
            else if (strs.length == 3) {
                int key = Integer.valueOf(strs[1]);
                int val = Integer.valueOf(strs[2]);
                set(key, val);
            }

            // evict
            else {
                // not empty in cache
                if (head.next != tail) {
                    // remove the key of tail.prev in the map
                    for (int key : map.keySet()) {
                        if (map.get(key) == tail.prev) {
                            map.remove(key);
                            break;
                        }
                    }
                    // remove the prev node of tail
                    remove(tail.prev);
                }
            }
        }

    }

    public static int get(int key) {
        Node n = map.get(key);
        if (null == n) {
            return -1;
        }
        update(n);
        return n.val;
    }

    public static void set(int key, int val) {
        Node n = map.get(key);
        if (null == n) {
            n = new Node(key, val);
            map.put(key, n);
            add(n);
        } else {
            n.val = val;
            update(n);
        }
    }

    private static void update(Node node) {
        remove(node);
        add(node);
    }

    private static void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private static void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    private static class Node {
        int key, val;

        Node prev, next;

        Node(int k, int v) {
            key = k;
            val = v;
        }

        Node() {
            this(0, 0);
        }
    }

}