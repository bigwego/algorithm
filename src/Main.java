import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        solve(points, n);
    }

    private static void solve(int[][] points, int n) {
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);

        boolean[] isValid = new boolean[n];
        isValid[n - 1] = true;

        int prevMaxY = points[n - 1][1];
        for (int i = n - 2; i > -1; i--) {
            if (points[i][1] <= prevMaxY) continue;
            isValid[i] = true;
            prevMaxY = points[i][1];
        }

        for (int i = 0; i < n; i++) {
            if (isValid[i])
                System.out.println(points[i][0] + " " + points[i][1]);
        }
    }
}