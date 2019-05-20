package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKInBT {

    private Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (K == 0) {
            res.add(target.val);
            return res;
        }
        buildGraph(root, null);

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        while (!queue.isEmpty()) {
            if (K == 0) {
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
                break;
            }
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                for (TreeNode next : graph.get(queue.poll())) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                    }
                }
            }
            K--;
        }
        return res;
    }

    private void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        graph.putIfAbsent(root, new ArrayList<>());
        if (parent != null) {
            graph.putIfAbsent(parent, new ArrayList<>());
            graph.get(root).add(parent);
            graph.get(parent).add(root);
        }
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }
}
