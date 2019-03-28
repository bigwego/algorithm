/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            map.put(curr, new UndirectedGraphNode(curr.label));
            for (UndirectedGraphNode next : curr.neighbors) {
                if (!map.containsKey(next)) {
                    queue.add(next);
                }
            }
        }
        for (UndirectedGraphNode ori : map.keySet()) {
            UndirectedGraphNode copy = map.get(ori);
            for (UndirectedGraphNode next : ori.neighbors) {
                copy.neighbors.add(map.get(next));
            }
        }
        return map.get(node);
    }
}
