public class MissingRanges {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        List<Long> list = new ArrayList<>();
        list.add(Long.valueOf(lower) - 1);
        for (int num : nums) {
            list.add(Long.valueOf(num));
        }
        list.add(Long.valueOf(upper) + 1);
        for (int i = 1; i < list.size(); i++) {
            long num1 = list.get(i - 1), num2 = list.get(i);
            if (num2 - num1 > 2) {
                res.add((num1 + 1) + "->" + (num2 - 1));
            } else if (num2 - num1 == 2) {
                res.add("" + (num1 + 1));
            }
        }
        return res;
    }
}
