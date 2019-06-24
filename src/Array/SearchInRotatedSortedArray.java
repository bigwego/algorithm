package Array;

// Problem 33. Search in Rotated Sorted Array
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int search2(int[] a, int target) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int l = 0, r = a.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int num = a[mid] < a[0] == target < a[0] ?
                    a[mid] : a[mid] < a[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (target == num) {
                return mid;
            } else if (target < num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return a[l] == target ? l : -1;
    }

    public int search3(int[] a, int target) {
        if (a == null || a.length == 0) return -1;

        int l = 0, r = a.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int num = a[mid] >= a[0] == target >= a[0] ?
                    a[mid] : target < a[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (num == target) return mid;
            else if (num > target) r = mid - 1;
            else l = mid + 1;
        }

        return a[l] == target ? l : -1;
    }
}