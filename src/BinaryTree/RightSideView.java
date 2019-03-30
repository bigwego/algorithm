package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>(Arrays.asList(root));
        TreeNode tmp;
        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                tmp = queue.poll();
                if (i == 0) {
                    res.add(tmp.val);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
            }
        }
        return res;
    }

    private class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
