package DynamicProgramming;

public class NumberofLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int max_len = 0;
        int[] lens = new int[n];
        int[] cnts = new int[n];
        for (int i = 0; i < n; i++) {
            lens[i] = cnts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lens[j] + 1 == lens[i]) {
                        cnts[i] += cnts[j];
                    } else if (lens[j] + 1 > lens[i]) {
                        lens[i] = lens[j] + 1;
                        cnts[i] = cnts[j];
                    }
                }
            }
            if (max_len < lens[i]) {
                max_len = lens[i];
                res = cnts[i];
            } else if (max_len == lens[i]) {
                res += cnts[i];
            }
        }
        return res;
    }
}
