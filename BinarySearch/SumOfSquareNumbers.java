class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int l = 0, r = (int) Math.sqrt(c);
        while (l <= r) {
            int num = l * l + r * r;
            if (num == c) return true;
            else if (num < c) l++;
            else r--;
        }
        return false;
    }
}
