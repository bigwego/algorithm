package Trie;

public class AddAndSearchWord {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode node = root;
        int idx = 0;
        for (char c : word.toCharArray()) {
            idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root;
        return match(node, word);
    }

    private boolean match(TrieNode node, String word) {
        if (word.length() == 0) {
            return node.isWord;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode next : node.children) {
                    if (next != null && match(next, word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
        }
        return node.isWord;
    }

    class TrieNode {
        TrieNode[] children;

        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}
