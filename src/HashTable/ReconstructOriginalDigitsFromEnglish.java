package HashTable;

public class ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        int[] cnts = new int[10];
        for (char c : s.toCharArray()) {
            if (c == 'z') {
                cnts[0]++;
            } else if (c == 'w') {
                cnts[2]++;
            } else if (c == 'u') {
                cnts[4]++;
            } else if (c == 'x') {
                cnts[6]++;
            } else if (c == 'g') {
                cnts[8]++;
            } else if (c == 'f') {
                cnts[5]++;
            } else if (c == 's') {
                cnts[7]++;
            } else if (c == 'h') {
                cnts[3]++;
            } else if (c == 'i') {
                cnts[9]++;
            } else if (c == 'o') {
                cnts[1]++;
            }
        }
        cnts[3] -= cnts[8];
        cnts[7] -= cnts[6];
        cnts[5] -= cnts[4];
        cnts[9] = cnts[9] - cnts[5] - cnts[6] - cnts[8];
        cnts[1] = cnts[1] - cnts[0] - cnts[2] - cnts[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < cnts[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
