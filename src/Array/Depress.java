package Array;

import java.util.Arrays;

public class Depress {

    public String depress(int m, int k, int[] arr) {
        Arrays.sort(arr);
        int res = 0;

        for (int i = 0, len = arr.length; i <= Math.min(len - 1, k); i++) {
            res += arr[i];
            if (res >= m) {
                return "yes";
            }
        }
        return "no";
    }
}
