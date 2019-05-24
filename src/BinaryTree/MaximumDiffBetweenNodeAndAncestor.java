package BinaryTree;

public class MaximumDiffBetweenNodeAndAncestor {

    private int maxAncestorDiff(TreeNode root) {
        return help(root, root.val, root.val);
    }

    private int help(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(help(node.left, max, min), help(node.right, max, min));
    }
}
