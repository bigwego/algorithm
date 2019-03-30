package String;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        int cnt = 1;
        StringBuilder sb = new StringBuilder(A);
        while (sb.length() < B.length()) {
            sb.append(A);
            cnt++;
        }
        if (sb.indexOf(B) != -1) {
            return cnt;
        }
        if (sb.append(A).indexOf(B) != -1) {
            return ++cnt;
        }
        return -1;
    }
}
