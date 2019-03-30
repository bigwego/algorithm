package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class BoundaryOfBinaryTree {

    /**
     * @param root: a TreeNode
     * @return a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        List<TreeNode> leaves = new ArrayList<>();
        traverseLeft(left, root.left);
        traverseRight(right, root.right);
        traverseLeaves(leaves, root);

        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for (int i = 0; i < left.size(); i++) {
            res.add(left.get(i).val);
        }
        for (int i = 1; i < leaves.size(); i++) {
            res.add(leaves.get(i).val);
        }
        for (int i = right.size() - 2; i > -1; i--) {
            res.add(right.get(i).val);
        }
        return res;
    }

    private void traverseLeaves(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node);
            return;
        }
        traverseLeaves(list, node.left);
        traverseLeaves(list, node.right);
    }

    private void traverseRight(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.right != null) {
            traverseRight(list, node.right);
        } else {
            traverseRight(list, node.left);
        }
    }

    private void traverseLeft(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        if (node.left != null) {
            traverseLeft(list, node.left);
        } else {
            traverseLeft(list, node.right);
        }
    }
}
