package Others;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) nums.add(i);

        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) f[i] = i * f[i - 1];

        k--;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int idx = k / f[n - 1];
            sb.append(nums.get(idx));
            nums.remove(idx);
            k %= f[n - 1];
            n--;
        }

        return sb.toString();
    }
}
