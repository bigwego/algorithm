package BinaryTree;

import java.util.LinkedList;

public class CheckCompletenessOfBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.peekFirst() != null) {
            TreeNode curr = queue.poll();
            queue.add(curr.left);
            queue.add(curr.right);
        }

        while (!queue.isEmpty() && queue.peekFirst() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}
