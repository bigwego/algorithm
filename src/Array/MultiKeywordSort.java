package Array;

import java.util.Arrays;

public class MultiKeywordSort {

    public int[][] multiSort(int[][] array) {
        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        return array;
    }
}
