class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++)
                sbs[j].append(s.charAt(i++));
            for (int k = numRows - 2; k > 0 && i < len; k--)
                sbs[k].append(s.charAt(i++));
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }
}
