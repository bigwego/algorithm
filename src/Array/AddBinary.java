package Array;

public class AddBinary {

    public String addBinary(String a, String b) {
        char[] chs1 = a.toCharArray();
        char[] chs2 = b.toCharArray();
        int idx1 = chs1.length - 1, idx2 = chs2.length - 1;
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        while (idx1 > -1 || idx2 > -1) {
            if (idx1 > -1) sum += chs1[idx1--] - '0';
            if (idx2 > -1) sum += chs2[idx2--] - '0';
            sb.append(sum & 1);
            sum /= 2;
        }

        if (sum != 0) sb.append(1);
        return sb.reverse().toString();
    }
}
