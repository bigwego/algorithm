class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int l = 0, h = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                h++;
            } else if (c == ')') {
                l--;
                h--;
            } else {
                l--;
                h++;
            }
            if (h < 0) return false;
            if (l < 0) l = 0;
        }
        return l > 0 ? false : true;
    }
}
