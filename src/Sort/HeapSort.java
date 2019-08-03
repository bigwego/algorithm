package Sort;

public class HeapSort {

    private static int[] arr;
//    private static int size;

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(new int[]{13,2,1});
        sort();
        for (int i : HeapSort.arr) {
            System.out.print(i + " ");
        }
    }

    public HeapSort(int[] arr) {
        HeapSort.arr = arr;
    }

    public static void sort() {
        buildHeap();
        System.out.println("bh end");
        for (int i : HeapSort.arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = arr.length - 1; i > 0; i--) {
            swap(0, i);
            shiftDown(0, i);
        }
    }

    private static void buildHeap() {
        for (int i = 1, len = arr.length; i < len; i++)
            shiftUp(i);
    }

    private static void shiftDown(int idx, int size) {
        int l;
        while ((l = 2 * idx + 1) < size) {
            int max = l;
            if (l + 1 < size && arr[l] < arr[l + 1])
                max++;
            if (arr[idx] > arr[max]) break;
            swap(idx, max);
            idx = max;
        }
    }

    private static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void shiftUp(int idx) {
        int tmp, p;
        while (idx != (p = (idx - 1) / 2) && arr[p] < arr[idx]) {
            tmp = arr[p];
            arr[p] = arr[idx];
            arr[idx] = tmp;
            idx = p;
        }
    }
}
