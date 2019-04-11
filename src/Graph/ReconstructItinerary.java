package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {

    private Map<String, PriorityQueue<String>> map;

    private LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        map = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    private void dfs(String airport) {
        Queue<String> nexts = map.get(airport);
        if (nexts != null) {
            while (!nexts.isEmpty()) {
                dfs(nexts.poll());
            }
        }
        path.addFirst(airport);
    }
}
