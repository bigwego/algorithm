package HashTable;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) {
            obs.add(o[0] + " " + o[1]);
        }

        int[][] dirs = new int[][]{ { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dir = 0;
        int res = 0;
        int x = 0;
        int y = 0;

        for (int command : commands) {
            if (command == -1) {
                dir++;
                if (dir == 4) {
                    dir = 0;
                }
            } else if (command == -2) {
                dir--;
                if (dir == -1) {
                    dir = 0;
                }
            } else {
                int cnt = 0;
                while (cnt < command && !obs.contains((x + dirs[dir][0]) + " " + (y + dirs[dir][1]))) {
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                }
                res = Math.max(res, x * x + y * y);
            }
        }

        return res;
    }
}
