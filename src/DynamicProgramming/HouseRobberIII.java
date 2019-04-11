package DynamicProgramming;

import BinaryTree.TreeNode;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] res = help(root);
        return Math.max(res[0], res[1]);
    }

    private int[] help(TreeNode node) {
        if (node == null) {
            return new int[]{ 0, 0 };
        }
        int[] left = help(node.left);
        int[] right = help(node.right);
        return new int[]{ node.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1]) };
    }
}
