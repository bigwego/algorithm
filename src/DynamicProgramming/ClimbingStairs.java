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
}
