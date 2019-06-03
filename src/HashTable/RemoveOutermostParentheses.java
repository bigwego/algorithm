package HashTable;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        int[] cnts = new int[2];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0, len = S.length(); j < len; j++) {
            if (S.charAt(j) == '(') {
                cnts[0]++;
            } else {
                cnts[1]++;
            }
            if (cnts[0] == 0 && cnts[1] == 0) {
                sb.append(S.substring(i, j + 1));
                i = j + 1;
            }
        }
        return sb.toString();
    }

    public String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int s = 0;
        int cnt = 1;
        for (int i = 1, len = S.length(); i < len; i++) {
            cnt += S.charAt(i) == '(' ? 1 : -1;
            if (cnt == 0) {
                sb.append(S.substring(s, i));
                s = i + 1;
            }
        }
        return sb.toString();
    }
}
