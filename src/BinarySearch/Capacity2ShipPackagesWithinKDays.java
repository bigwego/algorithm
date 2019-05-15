package BinarySearch;

public class Capacity2ShipPackagesWithinKDays {

    public int shipWithinDays(int[] weights, int k) {
        int left = weights[0], right = weights[0];
        for (int i = 1, len = weights.length; i < len; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int need = 1, curr = 0;
            for (int weight : weights) {
                if (curr + weight > mid) {
                    need++;
                    curr = weight;
                } else {
                    curr += weight;
                }
            }
            if (need > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
