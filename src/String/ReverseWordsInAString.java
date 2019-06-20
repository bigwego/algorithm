package String;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == ' ') continue;
            int tmp = i - 1;
            while (tmp > -1 && s.charAt(tmp) != ' ') tmp--;
            sb.append(s.substring(tmp + 1, i + 1)).append(" ");
            i = tmp;
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; ) {
            if (s.charAt(i) != ' ') {
                int j = i - 1;
                while (j > -1 && s.charAt(i) != ' ') j--;
                sb.append(s.substring(j + 1, i + 1)).append(" ");
                i = j - 1;
            } else {
                i--;
            }
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);

    }
}
