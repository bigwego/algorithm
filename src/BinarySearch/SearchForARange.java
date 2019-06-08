package BinarySearch;

public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            return new int[]{ -1, -1 };
        }

        int l = searchLeftMost(A, target);

        if (l == -1) {
            return new int[]{ -1, -1 };
        }

        int r = searchRightMost(A, target);

        return new int[]{ l, r };
    }

    private int searchRightMost(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                l = mid;
            } else if (a[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return a[r] == target ? r : l;
    }

    private int searchLeftMost(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                r = mid;
            } else if (a[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return a[l] == target ? l : r;
    }
}
