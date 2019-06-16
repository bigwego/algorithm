package BinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class DiameterOfBinaryTree {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return res;
    }

    private int help(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = help(node.left);
        int right = help(node.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        help2(root);
        return res;
    }

    private int help2(TreeNode node) {
        if (node == null) return 0;
        int left = help2(node.left);
        int right = help2(node.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
