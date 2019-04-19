package Others;

public class EliminationGame {

    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            step *= 2;
            left = !left;
            remaining /= 2;
        }
        return head;
    }
}
