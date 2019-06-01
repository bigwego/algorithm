package Array;

public class PreviousPermutationWithinOneSwap {

    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        int left = len - 2;

        while (left > -1 && A[left] <= A[left + 1]) {
            left--;
        }
        if (left == -1) {
            return A;
        }

        int right = len - 1;
        while (A[left] <= A[right]) {
            right--;
        }
        while (A[right] == A[right - 1]) {
            right--;
        }

        swap(A, left, right);

        return A;

    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
