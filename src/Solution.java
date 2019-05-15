import BinaryTree.TreeNode;

public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        if (l > r) {
            return null;
        }
        int maxIdx = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = constructMaximumBinaryTree(nums, l, maxIdx - 1);
        node.right = constructMaximumBinaryTree(nums, maxIdx + 1, r);
        return node;
    }
}