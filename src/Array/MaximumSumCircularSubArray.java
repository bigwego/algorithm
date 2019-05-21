package Array;

public class MaximumSumCircularSubArray {

    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        int currMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int currMin = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int a : A) {
            sum += a;
            currMax = Math.max(currMax + a, a);
            max = Math.max(max, currMax);
            currMin = Math.min(currMin + a, a);
            min = Math.min(min, currMin);
        }

        return max < 0 ? max : Math.max(max, sum - min);
    }
}
