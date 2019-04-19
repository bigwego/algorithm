package Design;

public class PhoneDirectory {

    private final int[] nums;

    private final boolean[] released;

    private int idx;

    public PhoneDirectory(int maxNumbers) {
        nums = new int[maxNumbers];
        released = new boolean[maxNumbers];
        idx = maxNumbers - 1;
        for (int i = 0; i < maxNumbers; i++) {
            nums[i] = i;
        }
    }

    public int get() {
        if (idx < 0) {
            return -1;
        }
        int res = nums[idx--];
        released[res] = true;
        return res;
    }

    public boolean check(int num) {
        return released[num];
    }

    public void release(int num) {
        if (released[num]) {
            nums[++idx] = num;
            released[num] = false;
        }
    }
}
