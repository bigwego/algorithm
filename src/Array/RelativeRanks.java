package Array;

import java.util.Arrays;
import java.util.Comparator;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        Integer[] idx = new Integer[nums.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        String[] res = new String[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[idx[i]] = "Gold Medal";
            } else if (i == 1) {
                res[idx[i]] = "Silver Medal";
            } else if (i == 2) {
                res[idx[i]] = "Bronze Medal";
            } else {
                res[idx[i]] = String.valueOf(i + 1);
            }
        }
        return res;
    }
}
