/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> map;

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return help(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);

	}

	private TreeNode help(int poststart, int instart, int inend, int[] postorder, int[] inorder) {

		if (poststart < 0 || instart > inend) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[poststart]);
		int inIndex = map.get(postorder[poststart]);

		root.left = help(poststart + inIndex - inend - 1, instart, inIndex - 1, postorder, inorder);
		root.right = help(poststart - 1, inIndex + 1, inend, postorder, inorder);
		return root;
	}
}
