public class MaximumDistanceInArrays {
    /**
     * @param arrs: an array of arrays
     * @return: return the max distance among arrays
     */
    public int maxDiff(int[][] arrs) {
        int min = arrs[0][0], max = arrs[0][arrs[0].length - 1], res = Integer.MIN_VALUE;
        for (int i = 1, len = arrs.length; i < len; i++) {
            res = Math.max(res, Math.max(arrs[i][arrs[i].length - 1] - min, max - arrs[i][0]));
            max = Math.max(max, arrs[i][arrs[i].length - 1]);
            min = Math.min(min, arrs[i][0]);
        }
        return res;
    }
}
