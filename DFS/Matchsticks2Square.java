class Matchsticks2Square {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums, 0, new int[4], sum / 4);
    }

    private boolean dfs(int[] nums, int idx, int[] sums, int target) {
        if (idx == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] + nums[idx] > target) {
                continue;
            }
            sums[i] += nums[idx];
            if (dfs(nums, idx + 1, sums, target)) {
                return true;
            }
            sums[i] -= nums[idx];
        }
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
