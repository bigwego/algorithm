package Others;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] res = new String[nums.length];
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        };
        Arrays.sort(res, comparator);
        if (res[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s);
        }
        return sb.toString();
    }
}
