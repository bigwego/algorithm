package BinarySearch;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (target < matrix[mid / n][mid % n]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return matrix[low / n][low % n] == target;
    }
}
