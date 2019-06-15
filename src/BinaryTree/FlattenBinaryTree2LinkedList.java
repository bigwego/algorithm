package BinaryTree;

// Problem 114. Flatten Binary Tree to Linked List
public class FlattenBinaryTree2LinkedList {

    TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
