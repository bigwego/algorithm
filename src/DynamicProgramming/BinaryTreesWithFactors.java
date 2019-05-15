package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreesWithFactors {

    public int numFactoredBinaryTrees(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;

        for (int num : A) {
            int cnt = 1;
            for (int key : map.keySet()) {
                if (num % key == 0 && map.containsKey(num / key)) {
                    cnt = (cnt + map.get(key) * map.get(num / key)) % mod;
                }
            }
            map.put(num, cnt);
        }

        int res = 0;
        for (int val : map.values()) {
            res += val;
        }
        return res;
    }
}
