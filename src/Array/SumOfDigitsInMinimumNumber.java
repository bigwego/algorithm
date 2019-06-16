package Array;

public class SumOfDigitsInMinimumNumber {

    public int sumOfDigits(int[] A) {
        int min = A[0];
        for (int i = 1, len = A.length; i < len; i++)
            min = Math.min(min, A[i]);

        int sum = 0;
        while (min != 0) {
            sum += min % 10;
            min /= 10;
        }

        return (sum & 1) == 1 ? 0 : 1;
    }
}
