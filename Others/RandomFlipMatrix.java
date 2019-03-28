class RandomFlipMatrix {
    int rows, cols, total;
    Map<Integer, Integer> map;
    Random rand;

    public Solution(int n_rows, int n_cols) {
        rows = n_rows;
        cols = n_cols;
        map = new HashMap<>();
        total = rows * cols;
        rand = new Random();
    }

    public int[] flip() {
        int idx = rand.nextInt(total--);
        int r = map.getOrDefault(idx, idx);
        map.put(idx, map.getOrDefault(total, total));
        return new int[]{r / cols, r % cols};
    }

    public void reset() {
        map.clear();
        total = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
