import BinaryTree.TreeNode;

public class Solution {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }
        if (root.right != null) {
            bstToGst(root.right);
        }
        root.val += sum;
        sum += root.val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }

}