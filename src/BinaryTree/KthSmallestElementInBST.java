package BinaryTree;

import java.util.Stack;

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

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }

        return -1;
    }
}
