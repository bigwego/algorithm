package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            map.putIfAbsent(item[0], new PriorityQueue<>());
            map.get(item[0]).add(item[1]);
            if (map.get(item[0]).size() > 5) {
                map.get(item[0]).poll();
            }
        }

        int[][] res = new int[map.size()][2];

        for (int i = 0, len = res.length; i < len; i++) {
            PriorityQueue<Integer> queue = map.get(i + 1);
            int sum = 0;
            while (!queue.isEmpty()) sum += queue.poll();
            res[i][0] = i + 1;
            res[i][1] = sum / 5;
        }

        return res;
    }
}
