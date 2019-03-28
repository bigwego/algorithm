/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		help(root);
		return res;
	}

	private int help(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(help(root.left), 0);
		int right = Math.max(help(root.right), 0);
		res = Math.max(res, Math.max(root.val + right + left, root.val + Math.max(left, right)));
		return root.val + Math.max(left, right);
	}
}
