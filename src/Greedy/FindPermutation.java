package Greedy;

public class FindPermutation {

    /**
     * @param s: a string
     * @return return a list of integers
     */
    public int[] findPermutation(String s) {
        int n = s.length();
        int cnt = 0;
        int num = 1;
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == n || s.charAt(i) == 'I') {
                for (int j = i; j >= i - cnt; j--) {
                    res[j] = num++;
                }
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return res;
    }
}
