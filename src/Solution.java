import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx - 1] < 0) {
                res.add(idx);
            } else {
                nums[idx - 1] *= -1;
            }
        }
        return res;
    }
}