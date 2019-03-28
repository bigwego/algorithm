class GameOfLife {
   public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = getNeighbours(board, i, j, m, n);
				if (board[i][j] == 1 && lives > 1 && lives < 4) {
					board[i][j] = 3;
				}
				if (board[i][j] == 0 && lives == 3) {
					board[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] >>= 1;
			}
		}
	}

	private int getNeighbours(int[][] board, int x, int y, int m, int n) {
		int res = 0;
		for (int i = Math.max(0, x - 1); i <= Math.min(m - 1, x + 1); i++) {
			for (int j = Math.max(0, y - 1); j <= Math.min(n - 1, y + 1); j++) {
				res += board[i][j] & 1;
			}
		}
		res -= board[x][y] & 1;
		return res;
	}

}
