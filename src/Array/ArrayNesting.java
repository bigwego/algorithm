package Array;

public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int cnt = 0;
            for (int j = i; nums[j] >= 0; cnt++) {
                int tmp = nums[j];
                nums[j] = -1;
                j = tmp;
            }
            res = Math.max(cnt, res);
        }
        return res;
    }
}
