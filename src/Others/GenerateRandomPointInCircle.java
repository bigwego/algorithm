package Others;

import java.util.Random;

public class GenerateRandomPointInCircle {

    private final double x;

    private final double y;

    private final double radius;

    private final Random rand;

    public GenerateRandomPointInCircle(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        this.radius = radius;
        rand = new Random();
    }

    public double[] randPoint() {
        while (true) {
            double randx = (2 * rand.nextDouble() / Double.MAX_VALUE - 1) * radius;
            double randy = (2 * rand.nextDouble() / Double.MAX_VALUE - 1) * radius;
            if (randx * randx + randy * randy <= radius * radius) {
                return new double[]{ randx + x, randy + y };
            }
        }
    }
}
