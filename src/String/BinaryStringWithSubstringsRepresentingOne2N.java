package String;

public class BinaryStringWithSubstringsRepresentingOne2N {

    public boolean queryString(String S, int N) {
        for (int i = N, min = N / 2; i > min; i--) {
            if (!S.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
