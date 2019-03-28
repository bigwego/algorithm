class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        Point[] points = new Point[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            points[2 * i] = new Point(buildings[i][0], buildings[i][2], true);
            points[2 * i + 1] = new Point(buildings[i][1], buildings[i][2], false);
        }
        Arrays.sort(points, new MyComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int preMax = 0;
        List<int[]> res = new ArrayList<>();
        for (Point point : points) {
            if (point.up) {
                map.put(point.height, map.getOrDefault(point.height, 0) + 1);
            } else {
                int cnt = map.get(point.height);
                if (cnt > 1) {
                    map.put(point.height, cnt - 1);
                } else {
                    map.remove(point.height);
                }
            }
            int currMax = map.lastKey();
            if (currMax != preMax) {
                res.add(new int[]{point.pos, currMax});
                preMax = currMax;
            }
        }
        return res;
    }

    class MyComparator implements Comparator<Point> {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.pos != o2.pos) {
                return o1.pos - o2.pos;
            } else {
                if (o1.up && o2.up) {
                    return o2.height - o1.height;
                } else if (!o1.up && !o2.up) {
                    return o1.height - o2.height;
                } else {
                    return o1.up ? -1 : 1;
                }
            }
        }
    }

    class Point {
        int pos;
        int height;
        boolean up;

        public Point(int pos, int height, boolean up) {
            this.pos = pos;
            this.height = height;
            this.up = up;
        }
    }
}
