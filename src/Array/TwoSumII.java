package Array;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int pre = 0;
        int pos = numbers.length - 1;
        int sum;
        int[] res = new int[2];

        while (pre < pos) {
            sum = numbers[pre] + numbers[pos];
            if (sum > target) {
                pos--;
            } else if (sum < target) {
                pre++;
            } else {
                res[0] = pre + 1;
                res[1] = pos + 1;
                break;
            }
        }
        return res;
    }
}
