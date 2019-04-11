package BinaryTree;

public class LargestBSTSubtree {

    public int largestBSTSubtree(TreeNode root) {
        return help(root)[2];
    }

    private int[] help(TreeNode node) {
        if (node == null) {
            return new int[]{ Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }
        int[] left = help(node.left);
        int[] right = help(node.right);
        if (node.val > left[1] && node.val < right[0]) {
            return new int[]{ left[0], right[1], left[2] + right[2] + 1 };
        } else {
            return new int[]{ Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2]) };
        }
    }
}
