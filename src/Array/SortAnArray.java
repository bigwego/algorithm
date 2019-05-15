package Array;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        int[] cnts = new int[100001];
        for (int num : nums) {
            cnts[num + 50000]++;
        }

        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 0, len = cnts.length; i < len; i++) {
            if (cnts[i] != 0) {
                int cnt = 0;
                while (cnt < cnts[i]) {
                    res[idx++] = i - 50000;
                    cnt++;
                }
            }
        }
        return res;
    }
}
