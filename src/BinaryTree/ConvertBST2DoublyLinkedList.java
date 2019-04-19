package BinaryTree;

import java.util.Stack;

/**
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 * int val;
 * DoublyListNode next, prev;
 * DoublyListNode(int val) {
 * this.val = val;
 * this.next = this.prev = null;
 * }
 * } * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */

public class ConvertBST2DoublyLinkedList {
    private DoublyListNode prev;

    private DoublyListNode head;

    /**
     * @param root: The root of tree
     * @return the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        DoublyListNode res = null;
        DoublyListNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            DoublyListNode node = new DoublyListNode(root.val);
            res = res == null ? node : res;
            if (pre != null) {
                node.prev = pre;
                pre.next = node;
            }
            pre = node;
            root = root.right;
        }
        return res;
    }

    public DoublyListNode bstToDoublyList2(TreeNode root) {
        help(root);
        return head;
    }

    private void help(TreeNode node) {
        if (node == null) {
            return;
        }
        help(node.left);
        DoublyListNode curr = new DoublyListNode(node.val);
        curr.prev = prev;
        if (prev != null) {
            prev.next = curr;
        } else {
            head = curr;
        }
        help(node.right);
    }

    private class DoublyListNode {
        int val;

        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            next = prev = null;
        }
    }
}