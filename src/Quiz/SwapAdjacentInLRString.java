package Quiz;

public class SwapAdjacentInLRString {

    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        int len = start.length();
        while (i < len && j < len) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (i == len && j == len) {
                return true;
            }
            if (i == len && j != len) {
                return false;
            }
            if (i != len && j == len) {
                return false;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
        }
        return true;
    }
}
