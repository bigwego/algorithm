package Others;

public class ShuffleArray {

    private final int[] nums;

    private final java.util.Random random;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        random = new java.util.Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] temp = nums.clone();
        for (int i = temp.length - 1; i > 0; i--) {
            int idx = random.nextInt(i + 1);
            swap(temp, idx, i);
        }
        return temp;
    }

    private void swap(int[] temp, int i, int j) {
        int tmp = temp[i];
        temp[i] = temp[j];
        temp[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
