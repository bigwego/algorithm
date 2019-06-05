package Array;

import java.util.Arrays;
import java.util.stream.Stream;

public class SortIntegers {

    public static void sortIntegers(int[] A) {
        for (int i = 1, len = A.length; i < len; i++) {
            int j = i - 1;
            for (; j > -1; j--) {
                if (A[j] <= A[i]) {
                    break;
                }
            }
            j++;
            int tmp = A[i];
            int idx = i;
            while (idx > j) {
                A[idx] = A[idx - 1];
                idx--;
            }
            A[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 4, 5 };
        sortIntegers(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
