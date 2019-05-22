package String;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public List<String> removeComments(String[] source) {
        int left = 0;
        int right = 0;
        List<String> res = new ArrayList<>();

        for (String s : source) {
            int idx1 = s.indexOf("/*");
            int idx2 = s.indexOf("*/");
            if (idx1 != -1 && idx2 != -1) {
                String tmp = s.substring(0, idx1) + s.substring(idx2 + 2, s.length());
                if (tmp.length() != 0) {
                    res.add(tmp);
                }
            } else if (idx1 != -1) {
                if (left == 0) {
                    left++;
                }
            } else if (idx2 != -1) {
                if (left != 0) {
                    continue;
                }
            }
        }
        return res;
    }
}
