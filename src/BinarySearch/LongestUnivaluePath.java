package BinarySearch;

import BinaryTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LongestUnivaluePath {

    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root, root.val);
        return res;
    }

    private int help(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int left = help(node.left, node.val);
        int right = help(node.right, node.val);
        res = Math.max(res, left + right);
        if (node.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
