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
public class SubtreeOfAnotherTree {

    private boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (s.val == t.val) return help(s, t);
        return isSubtree2(s.left, t) || isSubtree2(s.right, t);
    }

    private boolean help(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return help(s.left, t.left) && help(s.right, t.right);
    }
}
