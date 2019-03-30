package DFS;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, int i, int j, int curr, String word) {
        if (curr == word.length()) {
            return true;
        }
        if (i == -1 || j == -1 || i == m || j == n || board[i][j] != word.charAt(curr)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        if (dfs(board, m, n, i + 1, j, curr + 1, word) || dfs(board, m, n, i - 1, j, curr + 1, word) ||
                dfs(board, m, n, i, j + 1, curr + 1, word) || dfs(board, m, n, i, j - 1, curr + 1, word)) {
            return true;
        }
        board[i][j] = c;
        return false;
    }
}
