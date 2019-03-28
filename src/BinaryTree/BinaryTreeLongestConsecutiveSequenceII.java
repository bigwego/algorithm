/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class BinaryTreeLongestConsecutiveSequenceII {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int max = 0;

    public int longestConsecutive2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root);
        return max;
    }

    private int[] help(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = help(root.left);
        int[] right = help(root.right);
        int inc = 1, dec = 1;
        if (root.left == null || root.val + 1 == root.left.val) {
            inc = Math.max(inc, left[0] + 1);
        }
        if (root.right == null || root.val + 1 == root.right.val) {
            inc = Math.max(inc, right[0] + 1);
        }
        if (root.left == null || root.val - 1 == root.left.val) {
            dec = Math.max(dec, left[1] + 1);
        }
        if (root.right == null || root.val - 1 == root.right.val) {
            dec = Math.max(dec, right[1] + 1);
        }
        max = Math.max(max, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
