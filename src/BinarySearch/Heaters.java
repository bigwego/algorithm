class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0, i = 0;
        for (int house : houses) {
            while (i < heaters.length - 1
                    && Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)) {
                i++;
            }
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}
