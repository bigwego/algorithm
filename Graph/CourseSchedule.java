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
}
