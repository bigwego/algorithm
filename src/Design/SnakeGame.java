package Design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SnakeGame {

    private final int width;

    private final int height;

    private final LinkedList<int[]> snake;

    private final List<int[]> food;

    private Integer foodIdx;

    private Integer score;

    public SnakeGame(int width, int height, List<int[]> food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        snake.add(new int[]{ 0, 0 });
        foodIdx = 0;
        score = 0;
    }

    public int move(String direction) {
        int[] head = snake.peekFirst();
        int[] tail = snake.pollLast();
        if (direction.equals("U")) {
            head[0]--;
        } else if (direction.equals("D")) {
            head[0]++;
        } else if (direction.equals("L")) {
            head[1]--;
        } else {
            head[1]++;
        }
        if (head[0] == -1 || head[1] == -1 || head[0] == height || head[1] == width) {
            return -1;
        }
        snake.addFirst(head);
        if (!food.isEmpty() && Arrays.equals(head, food.get(foodIdx))) {
            snake.addLast(tail);
            foodIdx++;
            score++;
        }
        return score;
    }
}
