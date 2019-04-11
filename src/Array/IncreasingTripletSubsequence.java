package Array;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        Integer min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
