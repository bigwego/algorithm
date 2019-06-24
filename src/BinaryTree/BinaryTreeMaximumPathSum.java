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
public class BinaryTreeMaximumPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(help(root.left), 0);
        int right = Math.max(help(root.right), 0);
        res = Math.max(res, Math.max(root.val + right + left, root.val + Math.max(left, right)));
        return root.val + Math.max(left, right);
    }

    public int maxPathSum2(TreeNode root) {
        help2(root);
        return res;
    }

    private int help2(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(help2(node.left), 0);
        int right = Math.max(help2(node.right), 0);
        res = Math.max(res, node.val + left + right);
        return Math.max(left, right) + node.val;
    }
}
