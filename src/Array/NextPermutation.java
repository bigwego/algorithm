package Array;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int idx = nums.length - 2;
        while (idx > -1) {
            if (nums[idx] < nums[idx + 1]) {
                break;
            }
            idx--;
        }
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int fs = idx;
        idx = nums.length - 1;
        while (idx > fs) {
            if (nums[idx] > nums[fs]) {
                break;
            }
            idx--;
        }
        swap(nums, idx, fs);
        reverse(nums, fs + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation2(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length, idx = len - 2;

        while (idx > -1 && nums[idx] >= nums[idx + 1]) idx--;
        if (idx == -1) {
            reverse(nums, 0, len - 1);
            return;
        }

        int fs = idx;
        idx = len - 1;
        while (idx > fs && nums[idx] <= nums[fs]) idx--;
        swap(nums, fs, idx);
        reverse(nums, fs + 1, len - 1);
    }
}
