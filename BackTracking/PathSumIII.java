/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return help(root, map, 0, sum);
    }

    private int help(TreeNode node, Map<Integer, Integer> map, int sum, int target) {
        if (node == null) {
            return 0;
        }
        sum += node.val;
        int res = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += help(node.left, map, sum, target) + help(node.right, map, sum, target);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
}
