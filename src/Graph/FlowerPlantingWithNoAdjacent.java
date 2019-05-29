package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }

        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            int[] colors = new int[5];
            for (int val : graph.get(i)) {
                colors[res[val]] = 1;
            }
            for (int c = 1; c < 5; c++) {
                if (colors[c] == 0) {
                    res[i] = c;
                    break;
                }
            }
        }

        return res;
    }
}
