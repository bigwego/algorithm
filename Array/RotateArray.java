class RotateArray {
public void rotate(int[] nums, int k) {
    k %= nums.length;
		if (k == 0) {
			return;
		}
		int p = nums.length - k;
		reverse(nums, 0, p - 1);
		reverse(nums, p, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i++] = nums[j];
			nums[j--] = temp;
		}
	}
}
