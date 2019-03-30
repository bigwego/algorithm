package BinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int idx = maxIdx(nums, l, r);
        TreeNode node = new TreeNode(nums[idx]);
        node.left = construct(nums, l, idx - 1);
        node.right = construct(nums, idx + 1, r);
        return node;
    }

    private int maxIdx(int[] nums, int l, int r) {
        int idx = -1, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (max < nums[i]) {
                idx = i;
                max = nums[i];
            }
        }
        return idx;
    }
}
