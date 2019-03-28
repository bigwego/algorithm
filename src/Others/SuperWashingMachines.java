package Others;

public class SuperWashingMachines {

    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int cnt = 0;
        int res = 0;
        int avg = sum / machines.length;
        for (int machine : machines) {
            cnt += machine - avg;
            res = Math.max(Math.max(res, Math.abs(cnt)), machine - avg);
        }
        return res;
    }
}
