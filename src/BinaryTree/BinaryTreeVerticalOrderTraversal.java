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

public class BinaryTreeVerticalOrderTraversal {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> idxQueue = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        nodeQueue.add(root);
        idxQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int idx = idxQueue.poll();
            min = Math.min(min, idx);
            max = Math.max(max, idx);
            if (!map.containsKey(idx)) {
                map.put(idx, new ArrayList<>());
            }
            map.get(idx).add(node.val);
            if (node.left != null) {
                nodeQueue.add(node.left);
                idxQueue.add(idx - 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                idxQueue.add(idx + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
