package Others;

public class FindTheNumbersII {

    public int getSum(int A, int B) {
        int res = 0;

        while (A % 3 != 0 && A <= B) {
            A++;
        }

        while (A <= B) {
            res += A;
            A += 3;
        }

        return res;
    }
}
