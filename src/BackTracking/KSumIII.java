package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class KSumIII {

    int res = 0;

    public int getAns(int[] a, int k, int target) {
        Arrays.sort(a);
        if (k * a[0] > target || k * a[a.length - 1] < target) return 0;

        if (target % 2 == 0) {
            findEven(a, k, target);
            if (k % 2 == 0)
                findOdd(a, k, target);
        } else {
            if (k % 2 == 1)
                findOdd(a, k, target);
        }

        return res;
    }

    private void findEven(int[] a, int k, int target) {
        helpEven(new ArrayList<Integer>(), a, k, target, 0, 0);
    }

    private void helpEven(ArrayList<Integer> list, int[] a, int k, int target, int idx, int sum) {
        if (k == 0) {
            if (sum == target) res++;
            return;
        }

        for (int i = idx; i <= a.length - k && sum + a[i] <= target; i++) {
            if (a[i] % 2 == 0) {
                list.add(a[i]);
                helpEven(list, a, k - 1, target, i + 1, sum + a[i]);
                list.remove(list.size() - 1);
            }
        }
    }

    private void findOdd(int[] a, int k, int target) {
        helpOdd(new ArrayList<Integer>(), a, k, target, 0, 0);
    }

    private void helpOdd(ArrayList<Integer> list, int[] a, int k, int target, int idx, int sum) {
        if (k == 0) {
            if (sum == target) res++;
            return;
        }

        for (int i = idx; i <= a.length - k && sum + a[i] <= target; i++) {
            if (a[i] % 2 == 1) {
                list.add(a[i]);
                helpEven(list, a, k - 1, target, i + 1, sum + a[i]);
                list.remove(list.size() - 1);
            }
        }
    }
}
