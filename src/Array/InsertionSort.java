package Array;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        for (int i = 1, len = arr.length; i < len; i++) {
            int t = arr[i], j = i;
            for (; j > 0 && arr[j-1]>t; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
}
