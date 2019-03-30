package Array;

public class SortColors {

    public void sortColors(int[] nums) {
        int one = -1, two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, i++, ++one);
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
