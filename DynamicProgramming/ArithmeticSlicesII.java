class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer, Integer>[] maps = new Map[A.length];
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();
            for (int j = i - 1; j > -1; j--) {
                long diff = (long)A[i] - A[j];
                if (diff > Integer.MAX_VALUE || diff <= Integer.MIN_VALUE) {
                    continue;
                }
                int d = (int) diff;
                maps[i].put(d, maps[i].getOrDefault(d, 0) + 1);
                if (maps[j].containsKey(d)) {
                    res += maps[j].get(d);
                    maps[i].put(d, maps[i].get(d) + maps[j].get(d));
                }
            }
        }
        return res;
    }
}
