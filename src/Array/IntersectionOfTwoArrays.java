package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length * nums2.length == 0)
            return new int[]{};

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) set.add(num);
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        if (list.isEmpty()) return new int[]{};
        int[] res = new int[list.size()];
        for (int i = 0, len = res.length; i < len; i++)
            res[i] = list.get(i);

        return res;
    }
}
