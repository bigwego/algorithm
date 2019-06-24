package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < matrix[0].length; i++) {
            queue.add(new int[]{ matrix[0][i], 0, i });
        }
        int[] res = null;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
            if (res[1] == matrix.length - 1) {
                continue;
            }
            queue.add(new int[]{ matrix[res[1] + 1][res[2]], res[1] + 1, res[2] });
        }
        return res[0];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            queue.offer(new int[]{ 0, i, matrix[0][i] });

        while (true) {
            int[] curr = queue.poll();
            if (--k == 0) return curr[2];
            if (curr[0] != n - 1)
                queue.offer(new int[]{ curr[0] + 1, curr[1], matrix[curr[0] + 1][curr[1]] });
        }
    }
}
