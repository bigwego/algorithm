package BinaryTree;

public class CountCompleteTreeNodes {

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (ld == rd) {
            return (1 << ld) + countNodes(root.right);
        }
        return countNodes(root.left) + (1 << rd);
    }

    private int getDepth(TreeNode node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }
}
