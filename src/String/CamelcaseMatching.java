package String;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] chp = pattern.toCharArray();
        List<Boolean> res = new ArrayList<>();

        for (String query : queries) {
            char[] chq = query.toCharArray();
            res.add(isValid(chq, chp));
        }

        return res;
    }

    private Boolean isValid(char[] chq, char[] chp) {
        int j = 0;
        for (int i = 0, len = chq.length; i < len; i++) {
            if (j == chp.length) {
                return false;
            }
            if (chq[i] == chp[j]) {
                j++;
            } else if (Character.isUpperCase(chq[i])) {
                return false;
            }
        }
        return true;
    }
}
