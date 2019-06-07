package DFS;

import java.util.ArrayList;
import java.util.List;

public class CombinationAndJudgementPrimeNumber {

    List<Integer> sums = new ArrayList<>();

    public int getWays(int[] a, int k) {
        List<Integer> nums = new ArrayList<>();
        getAllNums(nums, a, k, 0, a.length);

        int res = 0;
        for (int sum : sums) {
            if (isPrime(sum)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int sum) {
        if (sum < 4) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void getAllNums(List<Integer> nums, int[] a, int k, int idx, int n) {
        if (nums.size() == k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            sums.add(sum);
            return;
        }

        for (int i = idx; i <= n - (k - nums.size()); i++) {
            nums.add(a[i]);
            getAllNums(nums, a, k, i + 1, n);
            nums.remove(nums.size() - 1);
        }
    }
}
