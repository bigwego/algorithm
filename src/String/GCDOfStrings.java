package String;

public class GCDOfStrings {

    private String gcdOfStrings(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        int len1 = str1.length();
        int len2 = str2.length();

        for (int len = len1; len > 0; len--) {
            if (len1 % len != 0 || len2 % len != 0) {
                continue;
            }
            String tmp = str1.substring(0, len);
            StringBuilder sb = new StringBuilder();
            int cnt = len1 / len;
            while (cnt-- > 0) {
                sb.append(tmp);
            }
            if (!str1.equals(sb.toString())) {
                continue;
            }
            sb = new StringBuilder();
            cnt = len2 / len;
            while (cnt-- > 0) {
                sb.append(tmp);
            }
            if (str2.equals(sb.toString())) {
                return tmp;
            }
        }

        return "";
    }

    private String gcdOfStrings2(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings2(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return "";
        }
        if (str2.isEmpty()) {
            return str1;
        }
        return gcdOfStrings2(str1.substring(str2.length()), str2);
    }

}
