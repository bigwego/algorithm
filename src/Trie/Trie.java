package Trie;

public class Trie {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.nexts[c - 'a'] == null) {
                node.nexts[c - 'a'] = new TrieNode();
            }
            node = node.nexts[c - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = handle(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return handle(prefix) != null;
    }

    private TrieNode handle(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.nexts[c - 'a'] == null) {
                return null;
            }
            node = node.nexts[c - 'a'];
        }
        return node;
    }

    private class TrieNode {
        TrieNode[] nexts = new TrieNode[26];

        boolean isEnd = false;
    }
}