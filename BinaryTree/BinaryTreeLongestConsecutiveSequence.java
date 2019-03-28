/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class BinaryTreeLongestConsecutiveSequence {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int res = 0;

    public int longestConsecutive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		help(root, 0, root.val);
		return res;
	}

	private void help(TreeNode root, int len, int target) {
		if (root == null) {
			return;
		}
		if (root.val == target) {
			len++;
		} else {
			len = 1;
		}
		res = Math.max(res, len);
		help(root.left, len, root.val + 1);
		help(root.right, len, root.val + 1);
	}
}
