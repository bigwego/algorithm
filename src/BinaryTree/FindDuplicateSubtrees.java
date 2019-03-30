package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        help(root, res, map);
        return res;
    }

    private String help(TreeNode node, List<TreeNode> res, HashMap<String, Integer> map) {
        if (node == null) {
            return "#";
        }
        String str = node.val + "!" + help(node.left, res, map) + "!" + help(node.right, res, map);
        if (map.getOrDefault(str, 0) == 1) {
            res.add(node);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}
