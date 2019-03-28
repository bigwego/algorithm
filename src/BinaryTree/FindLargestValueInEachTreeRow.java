/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int max;

		while (!queue.isEmpty()) {
			int size = queue.size();
			max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			ans.add(max);
		}
		return ans;
    }
}
