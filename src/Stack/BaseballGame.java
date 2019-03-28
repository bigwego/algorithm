class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String s : ops) {
            if (s.equals("C")) {
                res -= stack.pop();
            } else if (s.equals("D")) {
                int tmp = 2 * stack.peek();
                res += tmp;
                stack.push(tmp);
            } else if (s.equals("+")) {
                int a = stack.pop(), b = stack.pop();
                res += a + b;
                stack.push(b);
                stack.push(a);
                stack.push(a + b);
            } else {
                res += Integer.valueOf(s);
                stack.push(Integer.valueOf(s));
            }
        }
        return res;
    }
}
