package DFS;

public class Minesweeper {

    private char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] dirs = new int[][]{ { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int cnt = 0;
        for (int[] dir : dirs) {
            int ni = click[0] + dir[0];
            int nj = click[1] + dir[1];
            if (ni == -1 || nj == -1 || ni == m || nj == n) {
                continue;
            }
            if (board[ni][nj] == 'M' || board[ni][nj] == 'X') {
                cnt++;
            }
        }
        if (cnt != 0) {
            board[click[0]][click[1]] = (char) (cnt + '0');
        } else {
            board[click[0]][click[1]] = 'B';
            for (int[] dir : dirs) {
                int ni = click[0] + dir[0];
                int nj = click[1] + dir[1];
                if (ni == -1 || nj == -1 || ni == m || nj == n) {
                    continue;
                }
                if (board[ni][nj] == 'E') {
                    updateBoard(board, new int[]{ ni, nj });
                }
            }
        }
        return board;
    }
}
