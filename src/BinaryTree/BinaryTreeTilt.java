/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;

    public int findTilt(TreeNode root) {
        help(root);
        return sum;
    }

    private int help(TreeNode node) {
        if (node == null) return 0;
        int left = help(node.left);
        int right = help(node.right);
        sum += Math.abs(left - right);
        return left + right + node.val;
    }
}
