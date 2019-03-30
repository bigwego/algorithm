package DFS;

public class DecodeString {

    private int pos;

    private String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (Character.isDigit(c)) {
                num += c;
                pos++;
            } else if (c == '[') {
                pos++;
                String next = decodeString(s);
                for (int j = 0; j < Integer.valueOf(num); j++) {
                    sb.append(next);
                }
                num = "";
            } else if (c == ']') {
                pos++;
                return sb.toString();
            } else {
                sb.append(c);
                pos++;
            }
        }
        return sb.toString();
    }
}
