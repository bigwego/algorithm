package Others;

public class SquirrelSimulation {

    /**
     * @param height:   the height
     * @param width:    the width
     * @param tree:     the position of tree
     * @param squirrel: the position of squirrel
     * @param nuts:     the position of nuts
     * @return the minimal distance
     */
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int ti = tree[0];
        int tj = tree[1];
        int si = squirrel[0];
        int sj = squirrel[1];
        int res = 0, max_diff = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            int dist = Math.abs(nut[0] - ti) + Math.abs(nut[1] - tj);
            res += 2 * dist;
            max_diff = Math.max(max_diff, dist - Math.abs(nut[0] - si) - Math.abs(nut[1] - sj));
        }
        return res - max_diff;
    }
}
