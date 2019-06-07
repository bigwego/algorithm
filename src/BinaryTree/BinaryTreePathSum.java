package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        help(root, path, root.val, target);
        return res;
    }

    private void help(TreeNode node, List<Integer> path, int sum, int target) {
        if (node.left == null && node.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (node.left != null) {
            path.add(node.left.val);
            help(node.left,path,sum+node.left.val,target);
            path.remove(path.size()-1);
        }

        if (node.right != null) {
            path.add(node.right.val);
            help(node.right,path,sum+node.right.val,target);
            path.remove(path.size()-1);
        }
    }

}
