package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();

        for (int i = 1; i < 4; i++) {
            if (len - i > 9) continue;
            for (int j = i + 1; j < i + 4; j++) {
                if (len - j > 6) continue;
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    int a = Integer.valueOf(s.substring(0, i));
                    int b = Integer.valueOf(s.substring(i, j));
                    int c = Integer.valueOf(s.substring(j, k));
                    int d = Integer.valueOf(s.substring(k, len));
                    if (a > 255 || b > 255 || c > 255 || d > 255) continue;
                    String tmp = a + "." + b + "." + c + "." + d;
                    if (tmp.length() - len < 3) continue;
                    res.add(tmp);
                }
            }
        }

        return res;
    }
}
