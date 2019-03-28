class Solution {
    public boolean isPalindrome(String s) {
        char[] chs = s.toLowerCase().toCharArray();
		int left = 0;
		int right = chs.length - 1;
		while (left < right) {
			if (!((chs[left] >= 'a' && chs[left] <= 'z') || (chs[left] >= '0' && chs[left] <= '9'))) {
				left++;
				continue;
			}
			if (!((chs[right] >= 'a' && chs[right] <= 'z') || (chs[right] >= '0' && chs[right] <= '9'))) {
				right--;
				continue;
			}
			if (chs[left] != chs[right]) {
				return false;
			}
			left++;
			right--;

		}
		return true;
    }
}
