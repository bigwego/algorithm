package Array;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int ranIdx = l + (int) Math.random() * (r - l + 1);
        swap(arr, ranIdx, r);

        int[] p = partition(arr, l, r);
        quickSort(arr, l, p[0] - 1);
        quickSort(arr, p[1] + 1, r);
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1, more = r;

        while (l < more) {
            if (arr[l] < arr[r])
                swap(arr, l++, ++less);
            else if (arr[l] > arr[r])
                swap(arr, l, --more);
            else l++;
        }

        swap(arr, more, r);
        return new int[]{ less + 1, more };
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        quickSort(arr);
        for (int num : arr)
            System.out.print(num);
    }
}
