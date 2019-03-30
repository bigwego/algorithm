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
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean help(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (minValue < node.val && node.val < maxValue) {
            return help(node.left, minValue, node.val) && help(node.right, node.val, maxValue);
        }
        return false;
    }
}
