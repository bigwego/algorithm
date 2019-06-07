package BinarySearch;

public class FindPeakElementII {

    public int findPeak(int[] A) {
        int l = 0, r = A.length - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (A[mid] < A[mid + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return A[l] < A[r] ? r : l;
    }
}
