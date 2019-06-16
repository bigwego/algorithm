package HashTable;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                String key = "*" + board[i][j] + "*";
                if (!set.add(i + key) || !set.add(key + j) || !set.add(i / 3 + key + j / 3))
                    return false;
            }
        }

        return true;
    }
}
