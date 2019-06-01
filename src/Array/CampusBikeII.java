package Array;

public class CampusBikeII {

    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(0, workers, bikes, new boolean[bikes.length], 0);
        return min;
    }

    private void dfs(int idx, int[][] workers, int[][] bikes, boolean[] used, int sum) {
        if (idx == workers.length) {
            min = Math.min(min, sum);
            return;
        }
        if (sum >= min) {
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            dfs(idx + 1, workers, bikes, used, sum + getDis(workers[idx], bikes[i]));
            used[i] = false;
        }
    }

    private int getDis(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
