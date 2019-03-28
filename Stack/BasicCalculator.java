class BasicCalculator {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        int sign = 1, res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chs.length; i++) {
            if (Character.isDigit(chs[i])) {
                int num = 0;
                while (i < chs.length && Character.isDigit(chs[i])) {
                    num = 10 * num + chs[i++] - '0';
                }
                i--;
                res += sign * num;
            } else if (chs[i] == '+') {
                sign = 1;
            } else if (chs[i] == '-') {
                sign = -1;
            } else if (chs[i] == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (chs[i] == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
