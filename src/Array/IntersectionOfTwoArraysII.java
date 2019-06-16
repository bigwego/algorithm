package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                if (map.get(num) > 1) map.put(num, map.get(num) - 1);
                else map.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0, len = res.length; i < len; i++)
            res[i] = list.get(i);
        return res;
    }
}
