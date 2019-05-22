package BinarySearch;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        int r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        int l = 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int p : piles) {
                cnt += p % mid == 0 ? p / mid : p / mid + 1;
            }
            if (cnt <= H) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
