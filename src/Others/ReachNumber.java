package Others;

public class ReachNumber {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, step = 1;
        while (sum < target) {
            sum += step;
            step++;
        }
        int diff = sum - target;
        if (diff % 2 == 0) {
            return step - 1;
        }
        return step % 2 == 0 ? step + 1 : step;
    }
}
