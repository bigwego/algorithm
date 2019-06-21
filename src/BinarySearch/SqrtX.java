package BinarySearch;

public class SqrtX {

    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 1, right = x / 2;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return (long) left * left > x ? left - 1 : left;
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;

        int l = 1, r = x / 2;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) return mid;
            if (mid > x / mid) r = mid - 1;
            else l = mid + 1;
        }

        return l * l > x ? l - 1 : l;
    }
}
