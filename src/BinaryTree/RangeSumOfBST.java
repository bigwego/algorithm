package BinaryTree;

public class RangeSumOfBST {

    int res = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        traverse(root, L, R);
        return res;
    }

    private void traverse(TreeNode node, int l, int r) {
        if (node == null) {
            return;
        }
        traverse(node.left, l, r);
        if (node.val > r) {
            return;
        } else if (node.val >= l) {
            res += node.val;
        }
        traverse(node.right, l, r);
    }
}
