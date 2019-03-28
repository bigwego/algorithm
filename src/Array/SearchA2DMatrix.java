class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
			return false;
		}
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = m * n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int midValue = matrix[mid / n][mid % n];
			if (midValue == target) {
				return true;
			} else if (midValue > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
    }
}
