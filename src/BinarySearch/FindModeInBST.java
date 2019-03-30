package BinarySearch;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class FindModeInBST {
    private Integer prev = null;

    private int maxCnt = 0;

    private int currCnt = 1;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        if (prev != null) {
            if (prev == node.val) {
                currCnt++;
            } else {
                currCnt = 1;
            }
        }
        if (currCnt > maxCnt) {
            maxCnt = currCnt;
            list.clear();
            list.add(node.val);
        } else if (currCnt == maxCnt) {
            list.add(node.val);
        }
        prev = node.val;
        inOrder(node.right, list);
    }
}
