package Array;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int mod = 1000000007;

        for (int i = 0, len = A.length; i < len; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;
            for (int j = 0; j < i; j++) {
                int tmp = A[i] + A[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        return res;
    }

    public int threeSumMulti2(int[] A, int target) {
        long[] cnts = new long[101];
        long res = 0;
        for (int a : A) {
            cnts[a]++;
        }

        for (int i = 0; i < 101; i++) {
            for (int j = i; j < 101; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) {
                    continue;
                }
                if (i == j) {
                    if (j == k) {
                        res += cnts[i] * (cnts[i] - 1) * (cnts[i] - 2) / 6;
                    } else {
                        res += cnts[i] * (cnts[i] - 1) * cnts[k] / 2;
                    }
                } else {
                    if (j < k) {
                        res += cnts[i] * cnts[j] * cnts[k];
                    }
                }
            }
        }

        return (int) res % 1000000007;
    }
}