package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import LinkedList.ListNode;

public class ConvertBinaryTree2LinkedListByDepth {

    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ListNode head = null, tail = head;
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    head = new ListNode(curr.val);
                    tail = head;
                } else {
                    tail.next = new ListNode(curr.val);
                    tail = tail.next;
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(head);
        }

        return res;
    }
}
