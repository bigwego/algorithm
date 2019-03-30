package String;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int idx = s.length() - 1;
        while (idx > -1 && s.charAt(idx) == ' ') {
            idx--;
        }
        if (idx == -1) {
            return 0;
        }
        int res = 0;
        while (idx > -1 && s.charAt(idx) != ' ') {
            res++;
            idx--;
        }
        return res;
    }
}
