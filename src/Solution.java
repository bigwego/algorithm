import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import BinaryTree.TreeNode;

public class Solution {

    public void removeTreeNode(TreeNode root, int value) {
        help(root, value);
    }

    private TreeNode help(TreeNode node, int value) {
        if (node == null) return null;

        if (node.val < value) node.right = help(node.right, value);
        else if (node.val > value) node.left = help(node.left, value);

        if (node.left == null && node.right == null) return null;

        TreeNode rightMin = findMin(node.right);
        node.val = rightMin.val;
        node.right = help(node.right, rightMin.val);

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer curr = it.next();
            if ((curr & 1) == 0) {
                try {
                    it.remove();
                } catch (ConcurrentModificationException e) {

                }
            }
        }
    }
}
