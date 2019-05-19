package Array;

public class PartitionArrayIntoDisjointInterval {

    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] min = new int[len];
        int[] max = new int[len];
        int currMin = A[len - 1];
        min[len - 1] = currMin;
        int currMax = A[0];
        max[0] = currMax;
        for (int i = 1; i < len; i++) {
            currMax = Math.max(currMax, A[i]);
            max[i] = currMax;
        }
        for (int i = len - 2; i > -1; i--) {
            currMin = Math.min(currMin, A[i]);
            min[i] = currMin;
        }
        for (int i = 0; i < len - 1; i++) {
            if (max[i] <= min[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}
