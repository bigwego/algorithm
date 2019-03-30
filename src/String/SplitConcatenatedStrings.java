package String;

import java.util.List;

public class SplitConcatenatedStrings {

    /**
     * @param strs: a list of string
     * @return return a string
     */
    public String splitLoopedString(List<String> strs) {
        String s = "";
        for (String str : strs) {
            String rev = reverse(str);
            if (str.compareTo(rev) < 0) {
                s += rev;
            } else {
                s += str;
            }
        }

        String max = "a";
        int len = 0;
        for (String str : strs) {
            String rev = reverse(str);
            String body = s.substring(len + str.length()) + s.substring(0, len);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= max.charAt(0)) {
                    String s1 = str.substring(i) + body + str.substring(0, i);
                    if (s1.compareTo(max) > 0) {
                        max = s1;
                    }
                }
                if (rev.charAt(i) >= max.charAt(0)) {
                    String s1 = rev.substring(i) + body + rev.substring(0, i);
                    if (s1.compareTo(max) > 0) {
                        max = s1;
                    }
                }
            }
            len += str.length();
        }
        return max;
    }

    private String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
