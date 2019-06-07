package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private void help(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        help(node.left, res);
        res.add(node.val);
        help(node.right, res);
    }
}
