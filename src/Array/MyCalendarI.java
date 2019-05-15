package Array;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {

    private final TreeMap<Integer, Integer> books;

    public MyCalendarI() {
        books = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = books.floorEntry(start);
        if (floor != null && start < floor.getValue()) {
            return false;
        }
        Map.Entry<Integer, Integer> ceiling = books.ceilingEntry(start);
        if (ceiling != null && end > ceiling.getKey()) {
            return false;
        }
        books.put(start, end);
        return true;
    }
}
