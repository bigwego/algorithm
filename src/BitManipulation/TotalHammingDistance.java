package BitManipulation;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >>> i) & 1;
            }
            res += cnt * (nums.length - cnt);
        }
        return res;
    }
}
