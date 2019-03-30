package BackTracking;

public class BeautifulArrangement {

    private int cnt = 0;

    public int countArrangement(int N) {
        if (N == 0) {
            return 0;
        }
        help(1, new boolean[N + 1], N);
        return cnt;
    }

    private void help(int pos, boolean[] visited, int n) {
        if (pos == n + 1) {
            cnt++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            if (i % pos == 0 || pos % i == 0) {
                visited[i] = true;
                help(pos + 1, visited, n);
                visited[i] = false;
            }
        }
    }
}
