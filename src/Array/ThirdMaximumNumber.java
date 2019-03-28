class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer max = null, sec_max = null, third_max = null;
        for (Integer num : nums) {
            if (num.equals(max) || num.equals(sec_max) || num.equals(third_max)) continue;
            if (max == null || num > max) {
                third_max = sec_max;
                sec_max = max;
                max = num;
            } else if (sec_max == null || num > sec_max) {
                third_max = sec_max;
                sec_max = num;
            } else if (third_max == null || num > third_max) {
                third_max = num;
            }
        }
        return third_max == null ? max : third_max;
    }
}
