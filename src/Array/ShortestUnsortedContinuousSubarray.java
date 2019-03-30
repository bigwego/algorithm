package Array;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int end = -2;
        int beg = -1;
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (max > nums[i]) {
                end = i;
            }
            if (min < nums[n - 1 - i]) {
                beg = n - 1 - i;
            }
        }
        return end - beg + 1;
    }
}
