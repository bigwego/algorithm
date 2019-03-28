class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        int cnt1 = 0, cnt2 = 0, i = 0, j = 0;
        while (cnt1 < n1) {
            if (chs1[i] == chs2[j]) {
                j++;
                if (j == chs2.length) {
                    j = 0;
                    cnt2++;
                }
            }
            i++;
            if (i == chs1.length) {
                i = 0;
                cnt1++;
            }
        }
        return cnt2 / n2;
    }
}
