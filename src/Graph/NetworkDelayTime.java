package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = buildGraph(times);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        boolean[] visited = new boolean[N + 1];
        int cnt = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        queue.add(new int[]{ K, 0 });
        visited[K] = true;

        int res = -1;

        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int currV = edge[0];
            int currD = edge[1];
            if (visited[currV] || dist[currV] < currD) {
                continue;
            }
            visited[currV] = true;
            cnt++;
            List<int[]> edges = graph.get(currV);
            if (edges != null) {
                for (int[] next : edges) {
                    int nextV = next[0];
                    int nextD = next[1];
                    if (visited[nextV] || dist[nextV] < dist[currV] + nextD) {
                        continue;
                    }
                    dist[nextV] = dist[currV] + nextD;
                    res = Math.max(res, dist[nextV]);
                    queue.add(new int[]{ nextV, dist[nextV] });
                }
            }
        }

        return cnt == N ? -1 : res;
    }

    private Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{ time[1], time[2] });
        }
        return graph;
    }
}