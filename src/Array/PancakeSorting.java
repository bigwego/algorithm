package Array;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int len = A.length;
        for (int i = len - 1; i > 0; i--) {
            int maxIdx = findMax(A, i);
            if (maxIdx != i) {
                flip(A, 0, maxIdx);
                flip(A, 0, i);
                res.add(maxIdx + 1);
                res.add(i + 1);
            }
        }
        return res;
    }

    private void flip(int[] a, int i, int maxIdx) {
        int l = i;
        int r = maxIdx;
        while (l < r) {
            int tmp = a[l];
            a[l++] = a[r];
            a[r--] = tmp;
        }
    }

    private int findMax(int[] a, int r) {
        int res = r;
        for (int i = r - 1; i > -1; i--) {
            if (a[i] > a[res]) {
                res = i;
            }
        }
        return res;
    }
}
