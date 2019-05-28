package Others;

public class RobotBoundedInCircle {

    public boolean isRobotBounded(String instructions) {
        int i = 0;
        int j = 0;
        int dirIdx = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                i += dirs[dirIdx][0];
                j += dirs[dirIdx][1];
            } else if (c == 'L') {
                dirIdx = (dirIdx + 3) % 4;
            } else {
                dirIdx = (dirIdx + 1) % 4;
            }
        }

        return (i == 0 && j == 0) || dirIdx == 0;
    }
}
