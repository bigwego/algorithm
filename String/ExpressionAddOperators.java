class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        help(res, "", num, target, 0, 0, 0);
        return res;
    }

    private void help(List<String> res, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length() && target == eval) {
            res.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }
            long curr = Long.valueOf(num.substring(pos, i + 1));
            if (pos == 0) {
                help(res, num.substring(pos, i + 1), num, target, i + 1, curr, curr);
            } else {
                help(res, path + "+" + num.substring(pos, i + 1), num, target, i + 1, eval + curr, curr);
                help(res, path + "-" + num.substring(pos, i + 1), num, target, i + 1, eval - curr, -curr);
                help(res, path + "*" + num.substring(pos, i + 1), num, target, i + 1, eval - multed + curr * multed, curr * multed);
            }
        }
    }
}
