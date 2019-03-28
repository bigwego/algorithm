public class SmallestRectangleEnclosingBlackPixels {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
		if (image == null || image.length == 0) {
            return 0;
        }
        int m = image.length, n = image[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
            maxX = Math.max(maxX, p[0]);
            maxY = Math.max(maxY, p[1]);
            for (int[] dir : dirs) {
                int nx = p[0] + dir[0];
                int ny = p[1] + dir[1];
                if (nx == -1 || ny == -1 || nx == m || ny == n || image[nx][ny] == '0') {
                    continue;
                }
                queue.add(new int[]{nx, ny});
                image[nx][ny] = '0';
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
	}
}
