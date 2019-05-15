package HashTable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExamRoom {

    private final PriorityQueue<Interval> queue;

    private final int N;

    public ExamRoom(int N) {
        queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.dist == o2.dist) {
                    return o1.x - o2.x;
                }
                return o2.dist - o1.dist;
            }
        });
        queue.add(new Interval(-1, N));
        this.N = N;
    }

    public int seat() {
        Interval it = queue.poll();
        int seat = 0;
        if (it.x == -1) {
            seat = 0;
        } else if (it.y == N) {
            seat = N - 1;
        } else {
            seat = (it.x + it.y) / 2;
        }
        queue.add(new Interval(it.x, seat));
        queue.add(new Interval(seat, it.y));
        return seat;
    }

    public void leave(int p) {
        Interval left = null;
        Interval right = null;
        List<Interval> seats = new ArrayList<>(queue);
        for (Interval it : seats) {
            if (it.y == p) {
                left = it;
            }
            if (it.x == p) {
                right = it;
            }
            if (left != null && right != null) {
                break;
            }
        }
        queue.remove(left);
        queue.remove(right);
        queue.add(new Interval(left.x, right.y));
    }

    class Interval {
        int x;

        int y;

        int dist;

        Interval(int x, int y) {
            this.x = x;
            this.y = y;
            dist = y - x;
        }
    }
}
