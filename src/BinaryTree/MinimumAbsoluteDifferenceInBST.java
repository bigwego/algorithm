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
public class MinimumAbsoluteDifferenceInBST {

    int res = Integer.MAX_VALUE;

    private Integer prev = null;

    private int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return res;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return res;
    }
}
