package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a point.
 * class Point {
 * int x;
 * int y;
 * Point() { x = 0; y = 0; }
 * Point(int a, int b) { x = a; y = b; }
 * }
 */

public class NumberOfIslandsII {

    /**
     * @param n: An integer
     * @param m: An integer
     * @param o: an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] o) {
        List<Integer> res = new ArrayList<>();
        if (o == null || o.length == 0) {
            return res;
        }
        int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        int islands = 0;
        for (Point p : o) {
            int idx = m * p.x + p.y;
            if (roots[idx] == -1) {
                roots[idx] = idx;
                islands++;
                for (int[] dir : dirs) {
                    int x = p.x + dir[0];
                    int y = p.y + dir[1];
                    int nidx = m * x + y;
                    if (x == -1 || y == -1 || x == n || y == m || roots[nidx] == -1) {
                        continue;
                    }
                    int r = findParent(roots, nidx);
                    if (r != idx) {
                        roots[r] = idx;
                        islands--;
                    }
                }
            }
            res.add(islands);
        }
        return res;
    }

    private int findParent(int[] roots, int i) {
        while (i != roots[i]) {
            roots[i] = roots[roots[i]];
            i = roots[i];
        }
        return i;
    }

    private class Point {
        int x;

        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
