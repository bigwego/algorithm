package Array;

public class IntervalStatistics {

    public long intervalStatistics(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        int left = 0, right = 0;
        long numOfOne = 0, sum = 0;

        while (right < arr.length){
            if (arr[right] == 1){
                numOfOne++;
                right++;
                continue;
            }

            if (arr[left] == 1){
                numOfOne--;
                left++;
                continue;
            }

            while (numOfOne > k){
                if (arr[left] == 1){
                    numOfOne--;
                }
                left++;
            }

            sum += right - left + 1 - numOfOne;

            right++;

        }

        return sum;
    }
}
