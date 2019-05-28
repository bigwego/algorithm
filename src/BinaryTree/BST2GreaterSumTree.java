package BinaryTree;

public class BST2GreaterSumTree {

    private int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        help(root);
        return root;
    }

    private void help(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            help(node.right);
        }
        node.val += pre;
        pre = node.val;
        if (node.left != null) {
            help(node.left);
        }
    }
}
