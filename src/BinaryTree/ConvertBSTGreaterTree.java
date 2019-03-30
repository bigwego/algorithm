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
public class ConvertBSTGreaterTree {

    private int prevSum = 0;

    private TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        root.val += prevSum;
        prevSum = root.val;
        convertBST(root.left);
        return root;
    }
}
