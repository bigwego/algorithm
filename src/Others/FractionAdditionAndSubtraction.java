package Others;

import java.util.Scanner;

public class FractionAdditionAndSubtraction {

    public String fractionAddition(String expression) {
        Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A = A * b + B * a;
            B = B * b;
            int gcd = gcd(A, B);
            A /= gcd;
            B /= gcd;
        }
        return A + "/" + B;
    }

    private int gcd(int a, int b) {
        return a == 0 ? Math.abs(b) : gcd(b % a, a);
    }
}
