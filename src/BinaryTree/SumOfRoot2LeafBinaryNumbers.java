package BinaryTree;

public class SumOfRoot2LeafBinaryNumbers {

    private final int MOD_NUMBER = 1000000007;

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return sum;
        }
        traverse(root, 0);
        return sum;
    }

    private void traverse(TreeNode node, int val) {
        if (node.left == null && node.right == null) {
            sum = (sum + 2 * val + node.val) % MOD_NUMBER;
            return;
        }
        if (node.left != null) {
            traverse(node.left, 2 * val + node.val);
        }
        if (node.right != null) {
            traverse(node.right, 2 * val + node.val);
        }
    }
}
