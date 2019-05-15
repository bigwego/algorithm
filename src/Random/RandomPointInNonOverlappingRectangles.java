package Random;

import java.util.Random;
import java.util.TreeMap;

public class RandomPointInNonOverlappingRectangles {

    private final Random rand = new Random();

    private final TreeMap<Integer, Integer> map;

    private final int[][] rects;

    private int sum;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0, len = rects.length; i < len; i++) {
            int[] rect = rects[i];
            sum += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(sum, i);
        }
    }

    public int[] pick() {
        return pick(rects[map.get(map.ceilingKey(rand.nextInt(sum) + 1))]);
    }

    private int[] pick(int[] rect) {
        int x = rand.nextInt(rect[2] - rect[0] + 1) + rect[0];
        int y = rand.nextInt(rect[3] - rect[1] + 1) + rect[1];
        return new int[]{ x, y };
    }
}
