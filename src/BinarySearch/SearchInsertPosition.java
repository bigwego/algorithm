package BinarySearch;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length - 1, mid;

        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return nums[l] < target ? l + 1 : l;
    }
}
