package DynamicProgramming;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class EscapeLargeMaze {

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) {
            return true;
        }

        Set<String> set = new HashSet<>();
        for (int[] block : blocked) {
            set.add(block[0] + "," + block[1]);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        queue.add(source);
        int maxCnt = 200 * (200 - 1) / 2;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == target[0] && curr[1] == target[1]) {
                return true;
            }
            if (++cnt > maxCnt) {
                return true;
            }
            for (int[] dir : dirs) {
                int ni = curr[0] + dir[0];
                int nj = curr[1] + dir[1];
                if (isValid(ni, nj, 1000000, set)) {
                    queue.add(new int[]{ ni, nj });
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int m, Set<String> set) {
        return i != -1 && j != -1 && i != m && j != m && !set.contains(i + "," + j);
    }
}
