package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        help(root, new ArrayList<Integer>(), 0, target);
        return res;
    }

    private void help(TreeNode node, ArrayList<Integer> list, int sum, int target) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (node.left != null) {
            help(node.left, list, sum + node.val, target);
        }
        if (node.right != null) {
            help(node.right, list, sum + node.val, target);
        }
        list.remove(list.size() - 1);
    }
}
