class DecodeString {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> cntStack = new Stack<>();
        int idx = 0, cnt = 0;
        String str = "";
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                while (Character.isDigit(s.charAt(idx))) {
                    cnt = 10 * cnt + s.charAt(idx++) - '0';
                }
                cntStack.push(cnt);
                cnt = 0;
                continue;
            } else if (c == '[') {
                strStack.push(str);
                str = "";
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int times = cntStack.pop();
                for (int i = 0; i < times; i++) {
                    sb.append(str);
                }
                str = sb.toString();
            } else {
                str += c;
            }
            idx++;
        }
        return str;
    }
}
