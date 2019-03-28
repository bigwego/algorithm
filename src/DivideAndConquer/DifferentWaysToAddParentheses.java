class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        char[] chs = input.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '+' || chs[i] == '-' || chs[i] == '*') {
                String sub1 = input.substring(0, i);
                String sub2 = input.substring(i + 1);
                List<Integer> list1 = diffWaysToCompute(sub1);
                List<Integer> list2 = diffWaysToCompute(sub2);
                for (int a : list1) {
                    for (int b : list2) {
                        if (chs[i] == '+') {
                            res.add(a + b);
                        } else if (chs[i] == '-') {
                            res.add(a - b);
                        } else {
                            res.add(a * b);
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
