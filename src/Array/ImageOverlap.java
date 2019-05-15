package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> la = new ArrayList<>();
        List<int[]> lb = new ArrayList<>();
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    la.add(new int[]{ i, j });
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 1) {
                    lb.add(new int[]{ i, j });
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (int[] a : la) {
            for (int[] b : lb) {
                String key = (a[0] - b[0]) + " " + (a[1] - b[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int res = 0;
        for (int val : map.values()) {
            res = Math.max(res, val);
        }
        return res;
    }
}
