public class BestMeetingPoint {
    /**
     * @param grid: a 2D grid
     * @return: the minimize travel distance
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(cols);
        int res = 0, row_mid = rows.get(rows.size() / 2), col_mid = cols.get(cols.size() / 2);
        for (int i = 0; i < rows.size(); i++) {
            res += Math.abs(rows.get(i) - row_mid) + Math.abs(cols.get(i) - col_mid);
        }
        return res;
    }
}
