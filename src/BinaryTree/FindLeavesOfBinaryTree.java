package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        help(root, res);
        return res;
    }

    private int help(TreeNode node, List<List<Integer>> list) {
        if (node == null) {
            return 0;
        }
        int left = help(node.left, list);
        int right = help(node.right, list);
        int idx = Math.max(left, right);
        if (idx == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(idx).add(node.val);
        return idx + 1;
    }
}
