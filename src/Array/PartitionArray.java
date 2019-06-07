package Array;

public class PartitionArray {

    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l <= r && nums[l] < k) {
                l++;
            }
            while (l <= r && nums[r] >= k) {
                r--;
            }
            if (l <= r) {
                swap(nums, l++, r--);
            }
        }

        return l;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
