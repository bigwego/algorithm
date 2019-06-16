package HashTable;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int[] cnts = new int[256];
        int res = 0;

        for (char c : S.toCharArray()) cnts[c]++;
        for (char c : J.toCharArray()) res += cnts[c];

        return res;
    }
}
