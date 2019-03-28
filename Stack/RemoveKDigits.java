class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while (idx < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(idx)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(idx++));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
