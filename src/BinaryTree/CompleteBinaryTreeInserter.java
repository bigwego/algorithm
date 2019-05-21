package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompleteBinaryTreeInserter {

    private final List<TreeNode> nodeList;

    public CompleteBinaryTreeInserter(TreeNode root) {
        nodeList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            nodeList.add(curr);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        nodeList.add(node);
        int size = nodeList.size();
        TreeNode p = nodeList.get((size - 2) / 2);
        if ((size & 1) == 1) {
            p.right = node;
        } else {
            p.left = node;
        }
        return p.val;
    }

    public TreeNode get_root() {
        return nodeList.get(0);
    }
}
