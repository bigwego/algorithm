package String;

import java.util.ArrayList;
import java.util.List;

public class WordSubSets {

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] cnts = new int[26];
        int[] tmp;
        for (String b : B) {
            tmp = getCnts(b);
            for (int i = 0; i < 26; i++) {
                cnts[i] = Math.max(cnts[i], tmp[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for (String a : A) {
            tmp = getCnts(a);
            int i = 0;
            for (; i < 26; i++) {
                if (tmp[i] > cnts[i]) {
                    break;
                }
            }
            if (i == 26) {
                res.add(a);
            }
        }

        return res;
    }

    private int[] getCnts(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }
}
