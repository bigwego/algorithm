package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class CutOffTreesForGolfEvent {

    private final int[][] dirs = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h > 1) {
                    pq.add(new int[]{ i, j, h });
                }
            }
        }

        int[] start = { 0, 0 };
        int res = 0;
        while (!pq.isEmpty()) {
            int[] tree = pq.poll();
            int step = getMinStep(forest, start, tree, m, n);
            if (step == -1) {
                return -1;
            }
            res += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }

        return res;
    }

    private int getMinStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        boolean foundTree = false;

        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int ni = curr[0] + dir[0];
                    int nj = curr[1] + dir[1];
                    if (ni != -1 && nj != -1 && ni != m && nj != n
                            && forest.get(ni).get(nj) != 0 && !visited[ni][nj]) {
                        queue.add(new int[]{ ni, nj });
                        visited[ni][nj] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
