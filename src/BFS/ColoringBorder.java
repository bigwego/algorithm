package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ColoringBorder {

    private final int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int clr = grid[r0][c0];
        LinkedList<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new int[]{ r0, c0 });
        set.add(r0 * n + c0);

        while (!queue.isEmpty()) {
            int r = queue.peek()[0];
            int c = queue.poll()[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (set.contains(nr * n + nc)) {
                    continue;
                }
                if (nr == -1 || nc == -1 || nr == m || nc == n || grid[nr][nc] != clr) {
                    grid[r][c] = color;
                } else {
                    queue.add(new int[]{ nr, nc });
                    set.add(nr * n + c);
                }
            }
        }
        return grid;
    }
}
