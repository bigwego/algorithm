package Heap;

public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;

        buildMapHeap(arr);

        int size = arr.length;

        while (size > 1) {
            swap(arr, 0, --size);
            heapify(arr, 0, size);
        }
    }

    private static void heapify(int[] arr, int idx, int size) {
        int left = 2 * idx + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[idx] ? largest : idx;
            if (largest == idx) break;
            swap(arr, largest, idx);
            idx = largest;
            left = 2 * idx + 1;
        }
    }

    private static void buildMapHeap(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            heapInsert(arr, i);
        }
    }

    private static void heapInsert(int[] arr, int idx) {
        while (arr[idx] > arr[(idx - 1) / 2]) {
            swap(arr, idx, (idx - 1) / 2);
            idx = (idx - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{};
        heapSort(arr);
        printArray(arr);
    }
}
