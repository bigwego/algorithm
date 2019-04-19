package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<int[]> res = new ArrayList<>();
        if (m == 0 || n == 0 || k == 0) {
            return res;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{ i, 0 });
        }
        while (!queue.isEmpty() && k-- > 0) {
            int[] curr = queue.poll();
            res.add(new int[]{ nums1[curr[0]], nums2[curr[1]] });
            if (curr[1] == n - 1) {
                continue;
            }
            queue.add(new int[]{ curr[0], curr[1] + 1 });
        }
        return res;
    }
}
