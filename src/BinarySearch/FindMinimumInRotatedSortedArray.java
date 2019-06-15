package BinarySearch;

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
        return Math.min(findMin(nums, i, mid), findMin(nums, mid + 1, j));
    }

    public int findMin2(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r])
                r = mid;
            else if (nums[mid] > nums[r])
                l = mid + 1;
        }

        return nums[l];
    }
}
