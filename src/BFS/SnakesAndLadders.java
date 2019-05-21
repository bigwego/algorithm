package BFS;

import java.util.LinkedList;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        LinkedList<Integer> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(1);
        visited[0][0] = true;
        int max = m * n;

        int res = 0;

        while (!queue.isEmpty()) {
            for (int i = 0, sz = queue.size(); i < sz; i++) {
                int curr = queue.poll();
                if (curr == max) {
                    return res;
                }
                for (int j = 1; j < 7; j++) {
                    int next = curr + j;
                    if (next > max) {
                        continue;
                    }
                    int r = (next - 1) / m;
                    int c = (r & 1) == 0 ? (next - 1) % n - 1 : n - 1 - (next - 1) % n;
                    if (!visited[r][r]) {
                        queue.add(board[r][c] == -1 ? next : board[r][c]);
                        visited[r][c] = true;
                    }
                }
            }
            res++;
        }

        return -1;
    }
}
