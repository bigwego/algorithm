package DynamicProgramming;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int minusOne = 2, minusTwo = 1;
        for (int i = 2; i < n; i++) {
            int temp = minusOne;
            minusOne += minusTwo;
            minusTwo = temp;
        }
        return minusOne;
    }

    public int climbStairs2(int n) {
        if (n < 3) return n;

        int one = 2, two = 1;
        for (int i = 2; i < n; i++) {
            int tmp = one;
            one += two;
            two = tmp;
        }

        return one;
    }
}
