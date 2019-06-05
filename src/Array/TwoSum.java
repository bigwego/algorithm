package Array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{ map.get(target - numbers[i]), i };
            } else {
                map.put(numbers[i], i);
            }
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = numbers.length; i < len; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{ map.get(target - numbers[i]), i };
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
