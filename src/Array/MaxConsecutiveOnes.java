package Array;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            } else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        res = Math.max(res, cnt);
        return res;
    }
}
