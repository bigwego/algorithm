package Stack;

import java.util.Stack;

// Problem 735. Asteroid Collision
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (stack.isEmpty() || a > 0 || stack.peek() < 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() + a < 0) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() + a == 0) {
                    stack.pop();
                    continue;
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i > -1; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
