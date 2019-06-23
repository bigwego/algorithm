package Array;

import java.util.Random;

// Problem 215. Kth Largest Element in an Array
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private void shuffle(int[] a) {
        Random random = new Random();
        for (int ind = 1; ind < a.length; ind++) {
            int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    private int partition(int[] nums, int low, int hi) {
        int i = low, j = hi + 1;
        while (true) {
            while (i < hi && nums[++i] < nums[low]) {
            }
            while (j > low && nums[low] < nums[--j]) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        k = nums.length - k;
        while (l < r) {
            int p = partition2(nums, l, r);
            if (p == k) {
                break;
            } else if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        return nums[k];
    }

    private int partition2(int[] nums, int l, int r) {
        int i = l, j = r + 1;
        while (true) {
            while (i < r && nums[++i] < nums[l]) {
            }
            while (j > l && nums[l] < nums[--j]) {
            }

            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public int findKthLargest3(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        k = nums.length - k;

        while (l < r) {
            int p = partition3(nums, l, r);
            if (p == k) break;
            if (p > k) r = p - 1;
            else l = p + 1;
        }

        return nums[k];
    }

    private int partition3(int[] nums, int l, int r) {
        int pos = new Random().nextInt(r - l) + l + 1;
        swap(nums, l, pos);

        int i = l, j = r + 1;
        while (true) {
            while (i < r && nums[++i] < nums[l]) ;
            while (j > l && nums[--j] > nums[l]) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }
}
