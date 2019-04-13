package Design;

import java.util.LinkedList;

public class HitCounter {

    private final LinkedList<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.pollFirst();
        }
        return queue.size();
    }
}

//class HitCounter {
//
//    private final int[] timestamps;
//
//    private final int[] hits;
//
//    public HitCounter() {
//        timestamps = new int[300];
//        hits = new int[300];
//    }
//
//    public void hit(int timestamp) {
//        int idx = timestamp % 300;
//        if (idx != timestamp) {
//            timestamps[idx] = timestamp;
//            hits[idx] = 1;
//        } else {
//            hits[idx]++;
//        }
//    }
//
//    public int getHits(int timestamp) {
//        int res = 0;
//        for (int i = 0; i < 300; i++) {
//            if (timestamp - timestamps[i] < 300) {
//                res += hits[i];
//            }
//        }
//        return res;
//    }
//}