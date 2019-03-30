package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    private String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        return root.val + "!" + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split("!")));
        return deserialize(queue);
    }

    private TreeNode deserialize(LinkedList<String> queue) {
        String val = queue.pollFirst();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}
