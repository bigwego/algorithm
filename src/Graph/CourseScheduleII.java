package Graph;

import java.util.LinkedList;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
        }
        int[] res = new int[numCourses];
        int idx = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                res[idx++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] pre : prerequisites) {
                if (course == pre[1]) {
                    if (--indegrees[pre[0]] == 0) {
                        res[idx++] = pre[0];
                        queue.add(pre[0]);
                    }
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }
}
