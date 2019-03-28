/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        queue.add(root);
        int s = 0, e = 0, res = 0;
        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) s = map.get(curr);
                if (i == sz - 1) e = map.get(curr);
                if (curr.left != null) {
                    queue.add(curr.left);
                    map.put(curr.left, 2 * map.get(curr));
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    map.put(curr.right, 2 * map.get(curr) + 1);
                }
            }
            res = Math.max(res, e - s + 1);
        }
        return res;
    }
}
