package Array;

import java.util.TreeMap;

public class ArrayOfDoubledPairs {

    private static boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map);

        for (int num : A) {
            if (map.get(num) == 0) {
                continue;
            }
            int target = num < 0 ? num / 2 : num * 2;
            if ((num < 0 && num % 2 != 0) || !map.containsKey(target) || map.get(num) > map.get(target)) {
                return false;
            }
            map.put(target, map.get(target) - map.get(num));
        }

        return true;
    }

    public static void main(String[] args) {
        canReorderDoubled(new int[]{ 4, -2, 2, -4 });
    }
}
