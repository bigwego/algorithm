package BinaryTree;

public class PathSum {

    private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum2(root.left, sum - root.val)
                || hasPathSum2(root.right, sum - root.val);
    }
}
