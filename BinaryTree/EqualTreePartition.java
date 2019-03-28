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

public class EqualTreePartition {
    /**
     * @param root: a TreeNode
     * @return: return a boolean
     */
    public boolean checkEqualTree(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = getSum(root, map);
        if (sum == 0) return map.get(0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }

    private int getSum(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) return 0;
        int val = node.val + getSum(node.left, map) + getSum(node.right, map);
        map.put(val, map.getOrDefault(val, 0) + 1);
        return val;
    }
}
