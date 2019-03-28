class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String tmp = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 0, len = tmp.length(); i < len; ) {
            while (i < len - 1 && tmp.charAt(i) == tmp.charAt(i + 1)) {
                cnt++;
                i++;
            }
            sb.append(cnt).append(tmp.charAt(i));
            cnt = 1;
            i++;
        }
        return sb.toString();
    }
}
