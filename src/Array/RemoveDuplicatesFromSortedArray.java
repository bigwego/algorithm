package Array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rec = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++rec] = nums[i];
            }
        }
        return rec + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int idx = 0;

        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] != nums[idx])
                nums[++idx] = nums[i];
        }

        return idx + 1;
    }
}
