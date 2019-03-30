package BinaryTree;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class ClosestBinarySearchTreeValue {

    /**
     * @param root:   the given BST
     * @param target: the given target
     * @return the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            root = root.val < target ? root.right : root.left;
        }
        return res;
    }
}
