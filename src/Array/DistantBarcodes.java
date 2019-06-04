package Array;

import java.util.PriorityQueue;

public class DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] cnts = new int[10001];
        int len = barcodes.length;
        for (int b : barcodes) {
            cnts[b]++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < 10001; i++) {
            if (cnts[i] != 0)
                queue.add(new int[]{ i, cnts[i] });
        }

        int[] res = new int[len];
        int idx = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cnt = curr[1];
            while (cnt-- > 0) {
                res[idx] = curr[0];
                if (idx + 2 >= len)
                    idx = 1;
                else idx += 2;
            }
        }

        return res;
    }
}
