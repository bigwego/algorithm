package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        List<List<String>> res = new ArrayList<>(height);
        if (height == 0) {
            return res;
        }
        int rows = height;
        int cols = (int) Math.pow(2, height) - 1;
        LinkedList<String> row = new LinkedList<>();
        for (int i = 0; i < cols; i++) {
            row.add("");
        }
        for (int i = 0; i < rows; i++) {
            res.add(row);
        }
        populateRes(res, root, 0, 0, cols - 1);
        return res;
    }

    private void populateRes(List<List<String>> res, TreeNode node, int row, int i, int j) {
        if (row == res.size() || node == null) {
            return;
        }
        int pos = (i + j / 2);
        res.get(row).set(pos, "" + node.val);
        populateRes(res, node.left, row + 1, i, pos - 1);
        populateRes(res, node.right, row + 1, pos + 1, j);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
