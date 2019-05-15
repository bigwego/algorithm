package BinaryTree;

import java.util.Arrays;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double[][] cars = new double[len][2];
        for (int i = 0; i < len; i++) {
            cars[i] = new double[]{ position[i], (double) (target - position[i]) / speed[i] };
        }

        Arrays.sort(cars, (c1, c2) -> Double.compare(c1[0], c2[0]));

        int res = 0;
        double time = 0;
        for (int i = len - 1; i > -1; i--) {
            if (cars[i][1] > time) {
                res++;
                time = cars[i][1];
            }
        }
        return res;
    }
}
