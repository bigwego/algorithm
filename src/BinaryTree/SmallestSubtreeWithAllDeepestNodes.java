package BinaryTree;

public class SmallestSubtreeWithAllDeepestNodes {

    private TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left == right ?
                root : left > right ?
                subtreeWithAllDeepest(root.left) : subtreeWithAllDeepest(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
