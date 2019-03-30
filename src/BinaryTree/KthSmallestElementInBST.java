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
public class KthSmallestElementInBST {

    private int cnt = 0, res = 0;

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return res;
    }

    private void help(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        help(root.left, k);
        cnt++;
        if (cnt == k) {
            res = root.val;
            return;
        }
        help(root.right, k);
    }
}
