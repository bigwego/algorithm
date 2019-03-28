class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (xor >> i) & 1;
        }
        return cnt;
    }
}
