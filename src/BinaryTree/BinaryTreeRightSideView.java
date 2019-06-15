package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                TreeNode curr = queue.poll();
                if (i == 0)
                    res.add(curr.val);
                if (curr.right != null) queue.add(curr.right);
                if (curr.left != null) queue.add(curr.left);
            }
        }

        return res;
    }
}
