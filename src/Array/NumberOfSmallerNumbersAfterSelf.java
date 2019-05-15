package Array;

import java.util.ArrayList;
import java.util.List;

public class NumberOfSmallerNumbersAfterSelf {

    private int[] cnts;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        cnts = new int[len];
        int[] idxes = new int[len];
        for (int i = 0; i < len; i++) {
            idxes[i] = i;
        }

        mergeSort(nums, idxes, 0, len - 1);

        List<Integer> res = new ArrayList<>();
        for (int cnt : cnts) {
            res.add(cnt);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] idxes, int l, int r) {
        if (r >= l) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, idxes, l, mid);
        mergeSort(nums, idxes, mid + 1, r);
        merge(nums, idxes, l, r);
    }

    private void merge(int[] nums, int[] idxes, int l, int r) {
        int[] newIdxes = new int[r - l + 1];
        int mid = l + (r - l) / 2;
        int p1 = l;
        int p2 = mid + 1;
        int rightCnt = 0;
        int idx = 0;

        while (p1 <= mid && p2 <= r) {
            if (nums[idxes[p2]] < nums[idxes[p1]]) {
                newIdxes[idx] = idxes[p2++];
                rightCnt++;
            } else {
                newIdxes[idx] = idxes[p1];
                cnts[idxes[p1++]] += rightCnt;
            }
            idx++;
        }

        while (p1 <= mid) {
            newIdxes[idx++] = idxes[p1];
            cnts[idxes[p1++]] += rightCnt;
        }

        while (p2 <= r) {
            newIdxes[idx++] = idxes[p2++];
        }
        for (int i = l; i <= r; i++) {
            idxes[i] = newIdxes[i - l];
        }
    }
}
