class MapSumPairs {

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            if (key == null || key.length() == 0) return;
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (node.nexts[c - 'a'] == null)
                    node.nexts[c - 'a'] = new TrieNode();
                node = node.nexts[c - 'a'];
            }
            node.val = val;
        }

        public int sum(String prefix) {
            if (prefix == null || prefix.length() == 0) return 0;
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.nexts[c - 'a'] == null) return 0;
                node = node.nexts[c - 'a'];
            }
            return help(node);
        }

        private int help(TrieNode node) {
            int sum = 0;
            for (TrieNode next : node.nexts) {
                if (next != null) sum += help(next);
            }
            return (node.val == null ? 0 : node.val) + sum;
        }

        private class TrieNode {
            TrieNode[] nexts = new TrieNode[26];
            Integer val;
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
