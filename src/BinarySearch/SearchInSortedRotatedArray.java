package BinarySearch;

public class SearchInSortedRotatedArray {

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int l = 0, r = A.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[l] <= A[mid]) {
                if (A[l] <= target && target < A[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (A[mid] <= A[r]) {
                if (A[mid] < target && target <= A[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return A[l] == target ? l : -1;
    }
}
