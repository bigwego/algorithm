package DynamicProgramming;

public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n < 1) {
            return 1;
        }
        int res = 10;
        int availableNumbers = 9;
        int currUniqueDigits = 9;
        while (n-- > 1 && availableNumbers > 0) {
            currUniqueDigits *= availableNumbers;
            res += currUniqueDigits;
            availableNumbers--;
        }
        return res;
    }
}
