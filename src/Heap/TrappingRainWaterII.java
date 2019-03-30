package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{ i, 0, heightMap[i][0] });
            visited[i][0] = true;
            queue.add(new int[]{ i, n - 1, heightMap[i][n - 1] });
            visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            queue.add(new int[]{ 0, i, heightMap[0][i] });
            visited[0][i] = true;
            queue.add(new int[]{ m - 1, i, heightMap[m - 1][i] });
            visited[m - 1][i] = true;
        }
        int res = 0, max = Integer.MIN_VALUE;
        int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            max = Math.max(max, pos[2]);
            for (int[] dir : dirs) {
                int nx = pos[0] + dir[0];
                int ny = pos[1] + dir[1];
                if (nx > -1 && nx < m && ny > -1 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (heightMap[nx][ny] < max) {
                        res += max - heightMap[nx][ny];
                    }
                    queue.add(new int[]{ nx, ny, heightMap[nx][ny] });
                }
            }
        }
        return res;
    }
}
