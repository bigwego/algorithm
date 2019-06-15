package Array;

// Problem 283. Move Zeroes
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int rec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[rec++] = nums[i];
            }
        }
        while (rec < nums.length) {
            nums[rec++] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int idx = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != 0) nums[idx++] = nums[i];
        }

        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
