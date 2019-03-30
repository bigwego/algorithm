package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return help(0, 0, inorder.length - 1, preorder, inorder);

    }

    private TreeNode help(int prestart, int instart, int inend, int[] preorder, int[] inorder) {

        if (prestart > preorder.length - 1 || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inIndex = map.get(preorder[prestart]);
        root.left = help(prestart + 1, instart, inIndex - 1, preorder, inorder);
        root.right = help(prestart + inIndex - instart + 1, inIndex + 1, inend, preorder, inorder);
        return root;
    }
}
