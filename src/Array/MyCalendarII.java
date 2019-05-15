package Array;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarII {

    private final List<int[]> books;

    public MyCalendarII() {
        books = new ArrayList<>(100);
    }

    public boolean book(int start, int end) {
        for (int[] b : books) {
            if (Math.max(b[0], start) < Math.min(b[1], end)) {
                if (!MyCalendar.book(Math.max(b[0], start), Math.min(b[1], end))) {
                    return false;
                }
            }
        }
        books.add(new int[]{ start, end });
        return true;
    }

    private static class MyCalendar {
        static List<int[]> books = new ArrayList<>(100);

        static boolean book(int start, int end) {
            for (int[] b : books) {
                if (Math.max(b[0], start) < Math.min(b[1], end)) {
                    return false;
                }
            }
            books.add(new int[]{ start, end });
            return true;
        }
    }
}
