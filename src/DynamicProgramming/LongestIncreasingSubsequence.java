package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (num <= tails[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            tails[left] = num;
            if (left == len) {
                len++;
            }
        }
        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1, len = nums.length; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] tails = new int[len];
        int size = 0;

        for (int num : nums) {
            int l = 0, r = size;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (tails[mid] < num) l = mid + 1;
                else r = mid;
            }
            tails[l] = num;
            if (l == size) size++;
        }

        return size;
    }
}
