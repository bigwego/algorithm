package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MatrixCellsInDistanceOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> list = new ArrayList<>(R * C);
        int[][] dirs = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean[][] used = new boolean[R][C];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ r0, c0 });

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            used[i][j] = true;
            list.add(curr);
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni != -1 && nj != -1 && ni < R && nj < C && !used[ni][nj]) {
                    queue.add(new int[]{ ni, nj });
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
