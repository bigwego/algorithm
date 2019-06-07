package Array;

public class SortIntegerII {

    public void sortIntegers2(int[] A) {
        if (A == null) {
            return;
        }
        mergeSort(A, 0, A.length - 1);
    }

    private int[] mergeSort(int[] a, int l, int r) {
        if (l >= r) {
            return a;
        }
        int mid = l + (r - l) / 2;
        int[] left = mergeSort(a, l, mid);
        int[] right = mergeSort(a, mid + 1, r);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int len1 = left.length;
        int len2 = right.length;
        int[] res = new int[len1 + len2];
        int idx = 0;
        int l = 0, r = 0;

        while (l < len1 && r < len2) {
            if (left[l] < right[r]) {
                res[idx++] = left[l++];
            } else {
                res[idx++] = right[r++];
            }
        }

        while (l < len1) {
            res[idx++] = left[l++];
        }
        while (r < len2) {
            res[idx++] = right[r++];
        }

        return res;
    }
}
