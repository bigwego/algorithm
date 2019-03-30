import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Temp {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
            map.put(p[1], p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i : indegrees) {
            if (i == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (--indegrees[map.get(course)] == 0) {
                queue.add(map.get(course));
            }
        }
        for (int i : indegrees) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
