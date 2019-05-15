package Array;

import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum2(int[] A) {
        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int currSum = 0, cnt = 0;
        for (int num : A) {
            currSum += num;
            if (currSum != sum) {
                continue;
            }
            if (++cnt == 3) {
                return true;
            }
            currSum = 0;
        }
        return false;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }

        sum /= 3;
        int currSum = 0;
        for (int i = 0, len = A.length; i < len - 2; i++) {
            currSum += A[i];
            if (currSum == sum) {
                if (isValid(A, i + 1, sum)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int[] a, int idx, int sum) {
        int currSum = 0;
        for (int i = idx, len = a.length; i < len - 1; i++) {
            currSum += a[i];
            if (currSum == sum) {
                return true;
            }
        }
        return false;
    }
}
