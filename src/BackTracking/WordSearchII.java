package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(res, board, m, n, i, j, root);
            }
        }
        return res;
    }

    private void dfs(List<String> res, char[][] board, int m, int n, int i, int j, TrieNode root) {
        if (i == -1 || j == -1 || i == m || j == n) {
            return;
        }
        char c = board[i][j];
        if (c == '#') {
            return;
        }
        int idx = c - 'a';
        if (root.children[idx] == null) {
            return;
        }
        if (root.children[idx].word != null) {
            res.add(root.children[idx].word);
            root.children[idx].word = null;
        }
        board[i][j] = '#';
        dfs(res, board, m, n, i - 1, j, root.children[idx]);
        dfs(res, board, m, n, i + 1, j, root.children[idx]);
        dfs(res, board, m, n, i, j - 1, root.children[idx]);
        dfs(res, board, m, n, i, j + 1, root.children[idx]);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        String word;
    }
}
