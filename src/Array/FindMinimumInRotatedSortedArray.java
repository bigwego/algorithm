package Array;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int i, int j) {
        if (j - i < 2) {
            return Math.min(nums[i], nums[j]);
        }
        if (nums[i] < nums[j]) {
            return nums[i];
        }
        int mid = i + (j - i) / 2;
        return Math.min(findMin(nums, 0, mid - 1), findMin(nums, mid, j));
    }
}
