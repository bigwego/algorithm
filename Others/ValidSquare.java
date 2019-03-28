class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] lens = new long[]{length(p1, p2), length(p1, p3), length(p1, p4),
                length(p2, p3), length(p2, p4), length(p3, p4)};
        long max = 0, side = 0;
        int cnt = 0;
        for (long len : lens) {
            max = Math.max(max, len);
        }
        for (long len : lens) {
            if (len == max) cnt++;
            else side = len;
        }
        if (cnt != 2) return false;
        for (long len : lens) {
            if (len != max && len != side) return false;
        }
        return true;
    }

    private long length(int[] p1, int[] p2) {
        return (long) Math.pow(p1[0] - p2[0], 2) + (long) Math.pow(p1[1] - p2[1], 2);
    }
}
