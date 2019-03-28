class MaximumXOROfTwoNumbersInArray {
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i > -1; i--) {
                int currBit = (num >>> i) & 1;
                if (node.children[currBit] == null) {
                    node.children[currBit] = new TrieNode();
                }
                node = node.children[currBit];
            }
        }
        for (int num : nums) {
            int sum = 0;
            TrieNode node = root;
            for (int i = 31; i > -1; i--) {
                int currBit = (num >>> i) & 1;
                if (node.children[1 - currBit] != null) {
                    sum += (1 << i);
                    node = node.children[1 - currBit];
                } else {
                    node = node.children[currBit];
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }
}
