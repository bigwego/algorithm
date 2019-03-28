class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) {
            return res;
        }
        help(res, new ArrayList<Integer>(), n, 1, k);
        return res;
    }

    private void help(List<List<Integer>> res, ArrayList<Integer> list, int n, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            help(res, list, n, i + 1, k - 1);
            list.remove(list.size() - 1);
        }
    }
}
