package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean order = true;

        while (!list.isEmpty()) {
            LinkedList<Integer> row = new LinkedList<>();
            for (int i = 0, sz = list.size(); i < sz; i++) {
                TreeNode curr = list.poll();
                if (order) {
                    row.addLast(curr.val);
                } else {
                    row.addFirst(curr.val);
                }
                if (curr.left != null) list.add(curr.left);
                if (curr.right != null) list.add(curr.right);
            }
            res.add(row);
            order = !order;
        }

        return res;
    }
}
