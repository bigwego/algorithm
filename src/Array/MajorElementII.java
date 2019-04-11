package Array;

import java.util.ArrayList;
import java.util.List;

public class MajorElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int c1 = nums[0];
        int c2 = nums[0];
        int cnt1 = 0;
        int cnt2 = 0;
        int len = nums.length;
        for (int num : nums) {
            if (num == c1) {
                cnt1++;
            } else if (num == c2) {
                cnt2++;
            } else if (cnt1 == 0) {
                c1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                c2 = num;
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for (int num : nums) {
            if (num == c1) {
                cnt1++;
            } else if (num == c2) {
                cnt2++;
            }
        }
        if (cnt1 > len / 3) {
            res.add(c1);
        }
        if (cnt2 > len / 3) {
            res.add(c2);
        }
        return res;
    }
}
