class RotateImage {
    public void rotate(int[][] matrix) {

		reverse(matrix, 0, matrix.length - 1);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

	}

	private void reverse(int[][] matrix, int start, int end) {

		for (int i = 0; i < matrix[0].length; i++) {
			int x = start, y = end;
			while (x < y) {
				int temp = matrix[x][i];
				matrix[x++][i] = matrix[y][i];
				matrix[y--][i] = temp;
			}
		}
	}
}
