package HashTable;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] hash = new int[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        int odd = Integer.MIN_VALUE;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                if (hash[i] % 2 == 0) {
                    res += hash[i];
                } else {
                    odd = 1;
                    res += hash[i] - 1;
                }
            }
        }
        return odd == Integer.MIN_VALUE ? res : res + odd;
    }
}
