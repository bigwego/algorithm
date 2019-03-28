public class SplitArrayWithEqualSum {
    /**
     * @param nums: a list of integer
     * @return: return a boolean
     */
    public boolean splitArray(List<Integer> nums) {
        if (nums == null || nums.size() < 7) return false;
        int[] sums = new int[nums.size() + 1];
        for (int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + nums.get(i - 1);

        for (int j = 3; j < nums.size() - 3; j++) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (sums[i] == sums[j] - sums[i + 1]) {
                    if (!set.contains(sums[i])) set.add(sums[i]);
                }
            }
            for (int k = j + 2; k < nums.size() - 1; k++) {
                if (sums[k] - sums[j + 1] == sums[nums.size()] - sums[k + 1]) {
                    if (set.contains(sums[k] - sums[j + 1])) return true;
                }
            }
        }
        return false;
    }
}
