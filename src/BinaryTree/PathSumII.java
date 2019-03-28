/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		if(root==null) {
			return ans;
		}
		help(root,sum,ans,new ArrayList<Integer>());
		return ans;
	}

	private void help(TreeNode root, int sum, List<List<Integer>> ans, ArrayList<Integer> arrayList) {
		if(root==null) {
			return;
		}
		arrayList.add(root.val);
		if(root.left==null&&root.right==null&&sum==root.val) {
			ans.add(new ArrayList<>(arrayList));
            arrayList.remove(arrayList.size()-1);
			return;
		}
		help(root.left, sum-root.val, ans, arrayList);
		help(root.right, sum-root.val, ans, arrayList);
        arrayList.remove(arrayList.size()-1);
	}
}
