package Array;

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] add = new int[length + 1];
        int[] res = new int[length];
        for (int[] update : updates) {
            add[update[0]] += update[2];
            add[update[1] + 1] -= update[2];
        }
        res[0] = add[0];
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] + add[i];
        }
        return res;
    }
}
