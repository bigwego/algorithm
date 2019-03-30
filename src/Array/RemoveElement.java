package Array;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rec = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[rec++] = nums[i];
            }
        }
        return rec;
    }
}
