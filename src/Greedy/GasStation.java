package Greedy;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }
        sum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return start;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int sum = 0, len = gas.length;
        for (int i = 0; i < len; i++)
            sum += gas[i] - cost[i];

        if (sum < 0) return -1;

        sum = 0;
        int start = 0;

        for (int i = 0; i < len; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        return start;
    }
}
