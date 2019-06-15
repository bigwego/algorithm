package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
            if (!map.containsKey(p[1])) {
                map.put(p[1], new ArrayList<>());
            }
            map.get(p[1]).add(p[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (map.get(curr) != null) {
                    for (int next : map.get(curr)) {
                        if (--indegrees[next] == 0) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            int c1 = pre[0], c2 = pre[1];
            graph.putIfAbsent(c2, new HashSet<>());
            graph.get(c2).add(c1);
            indegrees[c1]++;
        }

        int cnt = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
                cnt++;
            }
        }

        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                int c = queue.poll();
                if (!graph.containsKey(c)) continue;
                for (int next : graph.get(c)) {
                    if (--indegrees[next] == 0) {
                        queue.add(next);
                        cnt++;
                    }
                }
            }
        }

        return cnt == numCourses;
    }
}
