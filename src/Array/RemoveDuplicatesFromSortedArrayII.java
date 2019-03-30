package Array;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int rec = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[rec - 2]) {
                nums[rec++] = nums[i];
            }
        }
        return rec;
    }
}
