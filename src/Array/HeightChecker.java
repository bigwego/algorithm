package Array;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);

        int res = 0;
        for (int i = 0, len = heights.length; i < len; i++) {
            if (heights[i] != copy[i]) {
                res++;
            }
        }

        return res;
    }
}
