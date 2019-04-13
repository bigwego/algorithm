package Design;

public class TicTacToe {

    private final int[] rows;

    private final int[] cols;

    private int diag;

    private int rev_diag;

    private final int winNum;

    public TicTacToe(int n) {
        rows = cols = new int[n];
        diag = rev_diag = winNum = n;
    }

    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        rows[row] += add;
        cols[col] += add;
        diag += row == col ? add : 0;
        rev_diag += row + col + 1 == winNum ? add : 0;
        return Math.abs(rows[row]) == winNum
                || Math.abs(cols[col]) == winNum
                || Math.abs(diag) == winNum
                || Math.abs(rev_diag) == winNum ? player : 0;
    }
}
