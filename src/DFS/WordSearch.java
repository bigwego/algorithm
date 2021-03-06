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

    public boolean exist2(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs2(board, i, j, m, n, 0, word))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs2(char[][] board, int i, int j, int m, int n, int idx, String word) {
        if (idx == word.length()) return true;
        if (i == -1 || j == -1 || i == m || j == n || board[i][j] != word.charAt(idx)) return false;

        char old = board[i][j];
        board[i][j] = '#';

        if (dfs2(board, i + 1, j, m, n, idx + 1, word) || dfs2(board, i - 1, j, m, n, idx + 1, word)
                || dfs2(board, i, j + 1, m, n, idx + 1, word) || dfs2(board, i, j - 1, m, n, idx + 1, word)) {
            return true;
        }

        board[i][j] = old;
        return false;
    }
}
