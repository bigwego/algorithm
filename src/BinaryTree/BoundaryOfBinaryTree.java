package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class BoundaryOfBinaryTree {

    /**
     * @param root: a TreeNode
     * @return a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        res.add(root.val);

        TreeNode curr = root.left;
        while (curr != null && (curr.left != null || curr.right != null)) {
            res.add(curr.val);
            curr = curr.left == null ? curr.right : curr.left;
        }

        dfs(root, res);

        curr = root.right;
        List<Integer> rightBound = new ArrayList<>();
        while (curr != null && (curr.left != null || curr.right != null)) {
            rightBound.add(curr.val);
            curr = curr.right == null ? curr.left : curr.right;
        }

        for (int i = rightBound.size() - 1; i > -1; i--)
            res.add(rightBound.get(i));

        return res;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
