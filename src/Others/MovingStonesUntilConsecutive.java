package Others;

import java.util.Arrays;

public class MovingStonesUntilConsecutive {

    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[]{ a, b, c };
        Arrays.sort(arr);
        if (arr[2] - arr[0] == 2) {
            return new int[]{ 0, 0 };
        }
        return new int[]{ Math.min(arr[1] - arr[0], arr[2] - arr[1]) < 2 ? 1 : 2, arr[2] - arr[0] - 2 };
    }
}
