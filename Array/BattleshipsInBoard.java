class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int res = 0, m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[i][j] == '.') ||
                        (i > 0 && board[i - 1][j] == 'X') ||
                        (j > 0 && board[i][j - 1] == 'X')) {
                    continue;
                }
                res++;
            }
        }
        return res;
    }
}
