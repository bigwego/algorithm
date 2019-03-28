class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        while (l < r) {
            long mid = l + (r - l) / 2;
            if (isValid(mid, nums, m)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private boolean isValid(long target, int[] nums, int m) {
        long sum = 0;
        int cnt = 1;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                cnt++;
                if (cnt > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
